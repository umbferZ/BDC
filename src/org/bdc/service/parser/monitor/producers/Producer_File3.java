/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.producers
 * Type: Producer_File3
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.producers;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File3;

public class Producer_File3 extends Producer<Bean_File3> {

    public Producer_File3(String fileName, QueueProducerConsumer<Bean_File3> queue) {
        super(fileName, queue);
    }

    @Override
    protected Class[] columnMappingType() {
        Class[] types = new Class[] { String.class, double.class, double.class, double.class, double.class, double.class, double.class };
        return types;
    }

}
