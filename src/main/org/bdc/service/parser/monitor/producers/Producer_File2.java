/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.producers
 * Type: Producer_File2
 * Last update: 12-mar-2017 16.25.13
 * 
 */

package main.org.bdc.service.parser.monitor.producers;

import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File2;

/**
 * The Class Producer_File2.
 */
public class Producer_File2 extends Producer<Bean_File2> {

    /**
     * Instantiates a new producer file 2.
     *
     * @param fileName the file name
     * @param queue the queue
     */
    public Producer_File2(String fileName, QueueProducerConsumer<Bean_File2> queue) {
        super(fileName, queue);
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.producers.Producer#columnMappingType()
     */
    @Override
    protected Class[] columnMappingType() {
        Class[] types = new Class[] { int.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class, double.class,
                double.class, double.class, double.class, double.class, double.class, double.class };
        return types;
    }

}
