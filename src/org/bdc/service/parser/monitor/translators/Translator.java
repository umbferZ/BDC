/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.translators
 * Type: Translator
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.translators;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.SimpleBean;
import org.bdc.service.parser.monitor.consumers.Consumer;
import org.bdc.service.parser.monitor.exceptions.FailedInsertException;
import org.bdc.service.parser.monitor.exceptions.FailedReadException;
import org.bdc.service.parser.monitor.producers.Producer;

public abstract class Translator<SB extends SimpleBean> {

    private String fileName;

    private QueueProducerConsumer<SB> queue;

    public Translator(String fileName) {
        this.fileName = fileName;
        queue = new QueueProducerConsumer<>();
    }

    public abstract Consumer<SB> getConsumer();

    public abstract Producer<SB> getProducer();

    public void translates() throws FailedInsertException, FailedReadException {
        long startTime = System.currentTimeMillis();
        Thread prod = new Thread(getProducer());
        prod.start();
        Thread cons = new Thread(getConsumer());
        cons.start();
        try {
            prod.join();
        } catch (InterruptedException e) {
            throw new FailedReadException();
        }

        try {
            cons.join();
        } catch (InterruptedException e) {
            throw new FailedInsertException();
        }
        System.out.println(String.format("Operazione eseguita in %d msec", System.currentTimeMillis() - startTime));

    }

    protected String getFileName() {
        return fileName;
    }

    protected QueueProducerConsumer<SB> getQueue() {
        return queue;
    }

    protected void setFileName(String fileName) {
        this.fileName = fileName;
    }

    protected void setQueue(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }
}
