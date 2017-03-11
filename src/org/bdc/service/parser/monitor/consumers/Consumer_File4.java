/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File4
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.consumers;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File4;

public class Consumer_File4 extends Consumer<Bean_File4> {

    public Consumer_File4(QueueProducerConsumer<Bean_File4> queue) {
        super(queue);
    }

    @Override
    protected void inserts(Bean_File4 bean) {

    }

}
