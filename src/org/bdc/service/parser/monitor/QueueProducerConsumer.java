/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor
 * Type: QueueProducerConsumer
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package org.bdc.service.parser.monitor;

import java.util.concurrent.ArrayBlockingQueue;

import org.bdc.service.parser.monitor.beans.SimpleBean;

/**
 * The Class QueueProducerConsumer.
 *
 * @param <SB> the generic type
 */
public class QueueProducerConsumer<SB extends SimpleBean> extends ArrayBlockingQueue<SB> {

    private static int capacity = 25;

    private boolean finished;

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
        return finished;
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