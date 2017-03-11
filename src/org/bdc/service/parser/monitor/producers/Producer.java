/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.producers
 * Type: Producer
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.producers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import org.bdc.service.parser.ParserValue;
import org.bdc.service.parser.exception.BadParseValueException;
import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.SimpleBean;

import com.opencsv.CSVReader;

public abstract class Producer<SB extends SimpleBean> implements Runnable {

    private String fileName;

    private QueueProducerConsumer<SB> queue;

    private Class<SB> typeBeanClass;

    @SuppressWarnings("unchecked")
    public Producer(String fileName, QueueProducerConsumer<SB> queue) {
        typeBeanClass = (Class<SB>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.fileName = fileName;
        this.queue = queue;
        columnMappingType();
    }

    public String getFileName() {
        return fileName;
    }

    public QueueProducerConsumer<SB> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        CSVReader csvReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferReader = new BufferedReader(fileReader);
            String[] nextLine;
            int counter = 0;
            while (counter < 3)
                if (bufferReader.readLine().contains("----"))
                    counter++;
            csvReader = new CSVReader(bufferReader, ',');
            csvReader.readNext();
            int i = 0;
            while ((nextLine = csvReader.readNext()) != null) {
                System.out.println(String.format("creazione %d", i++));
                queue.put(createBean(nextLine));

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
            queue.setFinished(true);
            try {
                csvReader.close();
                bufferReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setQueue(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }

    @SuppressWarnings("rawtypes")
    protected abstract Class[] columnMappingType();

    @SuppressWarnings("unchecked")
    private SB createBean(String... values) throws BadParseValueException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        Object[] parametersValue = new Object[columnMappingType().length];
        for (int i = 0; i < columnMappingType().length; i++)
            parametersValue[i] = ParserValue.parse(columnMappingType()[i], values[i]);
        Constructor<SB> constructor = typeBeanClass.getConstructor(columnMappingType());
        return constructor.newInstance(parametersValue);
    }
}