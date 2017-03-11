/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File2
 * Last update: 11-mar-2017 19.20.50
 * 
 */

package org.bdc.service.parser.monitor.consumers;

import org.bdc.model.entity.Clump;
import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File2;

public class Consumer_File2 extends Consumer<Bean_File2> {

    public Consumer_File2(QueueProducerConsumer<Bean_File2> queue) {
        super(queue);
    }

    @Override
    protected void inserts(Bean_File2 bean) {
        Clump clump = new Clump();
        clump.setId(bean.getClumpId());
        // FIXME create object

    }

}
