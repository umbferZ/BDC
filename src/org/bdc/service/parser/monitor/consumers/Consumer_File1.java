/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File1
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.consumers;

import org.bdc.model.entity.Clump;
import org.bdc.model.entity.Posizione;
import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.Bean_File1;

public class Consumer_File1 extends Consumer<Bean_File1> {

    public Consumer_File1(QueueProducerConsumer<Bean_File1> queue) {
        super(queue);
    }

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
