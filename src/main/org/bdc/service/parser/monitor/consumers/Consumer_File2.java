/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File2
 * Last update: 9-set-2017 11.43.06
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Band;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Ellipse;
import main.org.bdc.model.galaxy.Flusso;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File2;

/**
 * The Class Consumer_File2.
 */
public class Consumer_File2 extends Consumer<Bean_File2> {

    DaoFactory dao;

    /**
     * Instantiates a new consumer file 2.
     *
     * @param queue the queue
     */
    public Consumer_File2(QueueProducerConsumer<Bean_File2> queue) {
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
    protected void inserts(Bean_File2 bean) {
        try {

            Clump clump = dao.getClumpDao().getByIdOrNew(bean.getClumpId());

            Band u70, u160, u250, u350, u500;
            Flusso flow70, flow160, flow250, flow350, flow500;
            Ellipse el70, el160, el250, el350, el500;
            u70 = dao.getBandaDao().getByBand(70);
            u160 = dao.getBandaDao().getByBand(160);
            u250 = dao.getBandaDao().getByBand(250);
            u350 = dao.getBandaDao().getByBand(350);
            u500 = dao.getBandaDao().getByBand(500);
            flow70 = new Flusso(bean.getFlow_70(), u70);
            flow160 = new Flusso(bean.getFlow_160(), u160);
            flow250 = new Flusso(bean.getFlow_250(), u250);
            flow350 = new Flusso(bean.getFlow_350(), u350);
            flow500 = new Flusso(bean.getFlow_500(), u500);
            clump.addEllipse(new Ellipse(bean.gethMaxAx_70(), bean.gethMinAx_70(), bean.getAlpha_70(), u70, clump));
            clump.addEllipse(new Ellipse(bean.gethMaxAx_160(), bean.gethMinAx_160(), bean.getAlpha_160(), u160, clump));
            clump.addEllipse(new Ellipse(bean.gethMaxAx_250(), bean.gethMinAx_250(), bean.getAlpha_250(), u250, clump));
            clump.addEllipse(new Ellipse(bean.gethMaxAx_350(), bean.gethMinAx_350(), bean.getAlpha_350(), u350, clump));
            clump.addEllipse(new Ellipse(bean.gethMaxAx_500(), bean.gethMinAx_500(), bean.getAlpha_500(), u500, clump));

            dao.getClumpDao().insert(clump);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
