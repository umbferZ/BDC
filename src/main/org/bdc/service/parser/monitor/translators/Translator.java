/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.translators
 * Type: Translator
 * Last update: 20-set-2017 13.23.25
 * 
 */

package main.org.bdc.service.parser.monitor.translators;

import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.SimpleBean;
import main.org.bdc.service.parser.monitor.consumers.Consumer;
import main.org.bdc.service.parser.monitor.exceptions.FailedInsertException;
import main.org.bdc.service.parser.monitor.exceptions.FailedReadException;
import main.org.bdc.service.parser.monitor.producers.Producer;

/**
 * The Class Translator.
 *
 * @param <SB> the generic type
 */
public abstract class Translator<SB extends SimpleBean> implements Runnable {

    private String                    fileName;

    private QueueProducerConsumer<SB> queue;

    /**
     * Instantiates a new translator.
     *
     * @param fileName the file name
     */
    public Translator(String fileName) {
        this.fileName = fileName;
        this.queue = new QueueProducerConsumer<>();
    }

    /**
     * Gets the consumer.
     *
     * @return the consumer
     */
    public abstract Consumer<SB> getConsumer();

    /**
     * Gets the producer.
     *
     * @return the producer
     */
    public abstract Producer<SB> getProducer();

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            translates();
        } catch (FailedInsertException | FailedReadException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the file name.
     *
     * @return the file name
     */
    protected String getFileName() {
        return this.fileName;
    }

    /**
     * Gets the queue.
     *
     * @return the queue
     */
    protected QueueProducerConsumer<SB> getQueue() {
        return this.queue;
    }

    /**
     * Sets the file name.
     *
     * @param fileName the new file name
     */
    protected void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Sets the queue.
     *
     * @param queue the new queue
     */
    protected void setQueue(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }

    /**
     * Translates.
     *
     * @throws FailedInsertException the failed insert exception
     * @throws FailedReadException the failed read exception
     */
    private void translates() throws FailedInsertException, FailedReadException {
        long startTime = System.currentTimeMillis();
        Thread prod = new Thread(getProducer());
        prod.start();
        Thread cons = new Thread(getConsumer());
        cons.start();
        // try {
        // prod.join();
        // } catch (InterruptedException e) {
        // throw new FailedReadException();
        // }
        //
        // try {
        // cons.join();
        // } catch (InterruptedException e) {
        // throw new FailedInsertException();
        // }
        // System.out.println(String.format("Operazione eseguita in %d m",
        // System.currentTimeMillis() - startTime));

    }
}
