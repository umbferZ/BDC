/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.producers
 * Type: Producer_File1
 * Last update: 20-set-2017 13.23.20
 * 
 */

package main.org.bdc.service.parser.monitor.producers;

import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File1;

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

    /*
     * (non-Javadoc)
     * @see
     * main.org.bdc.service.parser.monitor.producers.Producer#columnMappingType(
     * )
     */
    @Override
    protected Class[] columnMappingType() {
        Class<?>[] types = new Class[] {
                int.class, double.class, double.class, double.class, double.class, double.class, int.class
        };
        return types;
    }

}
