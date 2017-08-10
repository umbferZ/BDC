/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.producers
 * Type: Producer_File4
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.monitor.producers;

import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File4;

/**
 * The Class Producer_File4.
 */
public class Producer_File4 extends Producer<Bean_File4> {

    /**
     * Instantiates a new producer file 4.
     *
     * @param fileName the file name
     * @param queue the queue
     */
    public Producer_File4(String fileName, QueueProducerConsumer<Bean_File4> queue) {
        super(fileName, queue);
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.producers.Producer#columnMappingType()
     */
    @Override
    protected Class[] columnMappingType() {
        Class[] types = new Class[] { String.class, double.class, double.class, double.class, double.class, String.class };
        return types;
    }

}
