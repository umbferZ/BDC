/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.producers
 * Type: Producer
 * Last update: 13-set-2017 0.30.13
 * 
 */

package main.org.bdc.service.parser.monitor.producers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import com.opencsv.CSVReader;

import main.org.bdc.service.parser.ParserValue;
import main.org.bdc.service.parser.exception.BadParseValueException;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.SimpleBean;

/**
 * The Class Producer.
 *
 * @param <SB> the generic type
 */
public abstract class Producer<SB extends SimpleBean> implements Runnable {

    private String                    fileName;

    private QueueProducerConsumer<SB> queue;

    private Class<SB>                 typeBeanClass;

    /**
     * Instantiates a new producer.
     *
     * @param fileName the file name
     * @param queue the queue
     */
    @SuppressWarnings("unchecked")
    public Producer(String fileName, QueueProducerConsumer<SB> queue) {
        this.typeBeanClass = (Class<SB>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.fileName = fileName;
        this.queue = queue;
        columnMappingType();
    }

    /**
     * Gets the file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Gets the queue.
     *
     * @return the queue
     */
    public QueueProducerConsumer<SB> getQueue() {
        return this.queue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        CSVReader csvReader = null;
        long time = 0;
        int rows = 0;
        try {
            fileReader = new FileReader(this.fileName);
            bufferReader = new BufferedReader(fileReader);
            String[] nextLine;
            int counter = 0;
            while (counter < 3)
                if (bufferReader.readLine().contains("----"))
                    counter++;
            csvReader = new CSVReader(bufferReader, ',');
            csvReader.readNext();
            while ((nextLine = csvReader.readNext()) != null) {
                long start = System.currentTimeMillis();
                this.queue.put(createBean(nextLine));
                time += System.currentTimeMillis() - start;
                rows++;
                // if (rows > 10)
                // break;
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (BadParseValueException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println(String.format("Producer sets finish"));
            if (rows > 0)
                System.out.println(String.format("Avarage time for read and enqueue is %d ms", time / rows));
            this.queue.setFinished(true);
            try {
                csvReader.close();
                bufferReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Sets the file name.
     *
     * @param fileName the new file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Sets the queue.
     *
     * @param queue the new queue
     */
    public void setQueue(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }

    /**
     * Column mapping type.
     *
     * @return the class[]
     */
    @SuppressWarnings("rawtypes")
    protected abstract Class[] columnMappingType();

    /**
     * Creates the bean.
     *
     * @param values the values
     * @return the sb
     * @throws BadParseValueException the bad parse value exception
     * @throws NoSuchMethodException the no such method exception
     * @throws SecurityException the security exception
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     * @throws IllegalArgumentException the illegal argument exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException the class not found exception
     */
    @SuppressWarnings("unchecked")
    private SB createBean(String... values) throws BadParseValueException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        Object[] parametersValue = new Object[columnMappingType().length];
        for (int i = 0; i < columnMappingType().length; i++)
            parametersValue[i] = ParserValue.parse(columnMappingType()[i], values[i]);
        Constructor<SB> constructor = this.typeBeanClass.getConstructor(columnMappingType());
        return constructor.newInstance(parametersValue);
    }
}