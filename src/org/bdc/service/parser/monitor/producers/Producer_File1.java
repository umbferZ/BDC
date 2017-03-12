/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.producers
 * Type: Producer_File1
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package org.bdc.service.parser.monitor.producers;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File1;

/**
 * The Class Producer_File1.
 */
public class Producer_File1 extends Producer<Bean_File1> {

    /**
     * Instantiates a new producer file 1.
     *
     * @param fileName the file name
     * @param queue the queue
     */
    public Producer_File1(String fileName, QueueProducerConsumer<Bean_File1> queue) {
        super(fileName, queue);
    }

    /* (non-Javadoc)
     * @see org.bdc.service.parser.monitor.producers.Producer#columnMappingType()
     */
    @Override
    protected Class[] columnMappingType() {
        Class<?>[] types = new Class[] { int.class, double.class, double.class, double.class, double.class, double.class, String.class };
        return types;
    }

}
