/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File3
 * Last update: 11-mar-2017 19.20.50
 * 
 */

package org.bdc.service.parser.monitor.consumers;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File3;

public class Consumer_File3 extends Consumer<Bean_File3> {

    public Consumer_File3(QueueProducerConsumer<Bean_File3> queue) {
        super(queue);
    }

    @Override
    protected void inserts(Bean_File3 bean) {

    }

}
