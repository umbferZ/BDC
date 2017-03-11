/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.producers
 * Type: Producer_File2
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.producers;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File2;

public class Producer_File2 extends Producer<Bean_File2> {

    public Producer_File2(String fileName, QueueProducerConsumer<Bean_File2> queue) {
        super(fileName, queue);
    }

    @Override
    protected Class[] columnMappingType() {
        Class[] types = new Class[] { int.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class,
                double.class, double.class, double.class, double.class, double.class, double.class };
        return types;
    }

}
