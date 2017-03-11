/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor
 * Type: QueueProducerConsumer
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor;

import java.util.concurrent.ArrayBlockingQueue;

import org.bdc.service.parser.monitor.beans.SimpleBean;

public class QueueProducerConsumer<SB extends SimpleBean> extends ArrayBlockingQueue<SB> {

    private static int capacity = 20;

    private boolean finished;

    public QueueProducerConsumer() {
        super(capacity);
        this.finished = false;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}