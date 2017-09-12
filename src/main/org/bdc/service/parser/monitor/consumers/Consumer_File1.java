/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File1
 * Last update: 9-set-2017 13.51.11
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.ClumpDetails;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File1;

/**
 * The Class Consumer_File1.
 */
public class Consumer_File1 extends Consumer<Bean_File1> {

    DaoFactory dao;

    /**
     * Instantiates a new consumer file 1.
     *
     * @param queue the queue
     */
    public Consumer_File1(QueueProducerConsumer<Bean_File1> queue) {
        super(queue);
        dao = DaoFactory.getInstance();
    }

    /*
     * (non-Javadoc)
     * @see
     * main.org.bdc.service.parser.monitor.consumers.Consumer#inserts(main.org.
     * bdc.service.parser.monitor.beans.SimpleBean)
     */
    @Override
    protected void inserts(Bean_File1 bean) {
        Clump clump = new Clump();
        ClumpDetails details = new ClumpDetails(clump, bean.getClumpType(), bean.getDensity(), bean.getRatioTempMass(), bean.getTemp(), bean.getLatitude(), bean.getLongitude());
        clump.setMap(new Map("Higal"));
        clump.setId(bean.getClumpId());
        clump.setClumpDetails(details);
        dao.getClumpDao().saveOrUpdate(clump);

    }

}
