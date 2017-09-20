/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor
 * Type: QueueProducerConsumer
 * Last update: 20-set-2017 13.23.25
 * 
 */

package main.org.bdc.service.parser.monitor;

import java.util.concurrent.ArrayBlockingQueue;

import main.org.bdc.service.parser.monitor.beans.SimpleBean;

/**
 * The Class QueueProducerConsumer.
 *
 * @param <SB> the generic type
 */
public class QueueProducerConsumer<SB extends SimpleBean> extends ArrayBlockingQueue<SB> {

    private static int capacity = 10;

    private boolean    finished;

    /**
     * Instantiates a new queue producer consumer.
     */
    public QueueProducerConsumer() {
        super(capacity);
        this.finished = false;
    }

    /**
     * Checks if is finished.
     *
     * @return true, if is finished
     */
    public boolean isFinished() {
        return this.finished;
    }

    /**
     * Sets the finished.
     *
     * @param finished the new finished
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}