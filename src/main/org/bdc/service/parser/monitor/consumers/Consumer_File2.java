/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File2
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.model.entity.Clump;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File2;

/**
 * The Class Consumer_File2.
 */
public class Consumer_File2 extends Consumer<Bean_File2> {

    /**
     * Instantiates a new consumer file 2.
     *
     * @param queue the queue
     */
    public Consumer_File2(QueueProducerConsumer<Bean_File2> queue) {
        super(queue);
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.consumers.Consumer#inserts(main.org.bdc.service.parser.monitor.beans.SimpleBean)
     */
    @Override
    protected void inserts(Bean_File2 bean) {
        Clump clump = new Clump();
        clump.setId(bean.getClumpId());
        // FIXME create object

    }

}
