/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File3
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File3;

/**
 * The Class Consumer_File3.
 */
public class Consumer_File3 extends Consumer<Bean_File3> {

    /**
     * Instantiates a new consumer file 3.
     *
     * @param queue the queue
     */
    public Consumer_File3(QueueProducerConsumer<Bean_File3> queue) {
        super(queue);
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.consumers.Consumer#inserts(main.org.bdc.service.parser.monitor.beans.SimpleBean)
     */
    @Override
    protected void inserts(Bean_File3 bean) {

    }

}
