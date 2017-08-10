/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.producers
 * Type: Producer_File3
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.monitor.producers;

import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File3;

/**
 * The Class Producer_File3.
 */
public class Producer_File3 extends Producer<Bean_File3> {

    /**
     * Instantiates a new producer file 3.
     *
     * @param fileName the file name
     * @param queue the queue
     */
    public Producer_File3(String fileName, QueueProducerConsumer<Bean_File3> queue) {
        super(fileName, queue);
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.producers.Producer#columnMappingType()
     */
    @Override
    protected Class[] columnMappingType() {
        Class[] types = new Class[] { String.class, double.class, double.class, double.class, double.class, double.class, double.class };
        return types;
    }

}
