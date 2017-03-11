/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor
 * Type: QueueProductorConsumer
 * Last update: 11-mar-2017 0.58.34
 * 
 */

package org.bdc.service.parser.monitor;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueProductorConsumer<SB extends SimpleBean> extends ArrayBlockingQueue<SB> {

    private static int capacity = 11;

    private static final long serialVersionUID = 1L;

    private boolean finished;

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        QueueProductorConsumer.capacity = capacity;
    }

    public QueueProductorConsumer() {
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