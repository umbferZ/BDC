/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File1
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.model.entity.Clump;
import main.org.bdc.model.entity.Posizione;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File1;

/**
 * The Class Consumer_File1.
 */
public class Consumer_File1 extends Consumer<Bean_File1> {

    /**
     * Instantiates a new consumer file 1.
     *
     * @param queue the queue
     */
    public Consumer_File1(QueueProducerConsumer<Bean_File1> queue) {
        super(queue);
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.consumers.Consumer#inserts(main.org.bdc.service.parser.monitor.beans.SimpleBean)
     */
    @Override
    protected void inserts(Bean_File1 bean) {
        Clump clump = new Clump();
        clump.setId(bean.getClumpId());
        clump.setTemperatura(bean.getTemp());
        clump.setDensita(bean.getDensity());
        clump.setRapportoMassaTemperatura(bean.getRatioTempMass());
        clump.setTipoClump(bean.getClumpType());
        clump.setPosizione(new Posizione(bean.getLongitude(), bean.getLatitude()));
        // DaoFactory.getInstance().getClumpDao().insert(clump);

    }

}
