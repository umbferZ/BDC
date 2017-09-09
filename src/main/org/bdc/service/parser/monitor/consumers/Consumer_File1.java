/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File1
 * Last update: 9-set-2017 11.44.01
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Posizione;
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
        clump.setMap(new Map("Higal"));
        clump.setId(bean.getClumpId());
        clump.setTemperatura(bean.getTemp());
        clump.setDensita(bean.getDensity());
        clump.setRapportoMassaTemperatura(bean.getRatioTempMass());
        clump.setClumpType(bean.getClumpType());
        clump.setPosizione(new Posizione(bean.getLongitude(), bean.getLatitude()));
        dao.getClumpDao().insert(clump);

    }

}
