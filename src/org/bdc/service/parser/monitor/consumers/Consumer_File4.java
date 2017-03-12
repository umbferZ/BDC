/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File4
 * Last update: 12-mar-2017 16.25.13
 * 
 */

package org.bdc.service.parser.monitor.consumers;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File4;

/**
 * The Class Consumer_File4.
 */
public class Consumer_File4 extends Consumer<Bean_File4> {

    /**
     * Instantiates a new consumer file 4.
     *
     * @param queue the queue
     */
    public Consumer_File4(QueueProducerConsumer<Bean_File4> queue) {
        super(queue);
    }

    /* (non-Javadoc)
     * @see org.bdc.service.parser.monitor.consumers.Consumer#inserts(org.bdc.service.parser.monitor.beans.SimpleBean)
     */
    @Override
    protected void inserts(Bean_File4 bean) {

    }

}
