/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File2
 * Last update: 11-set-2017 23.53.54
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import java.util.ArrayList;
import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Ellipse;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File2;

/**
 * The Class Consumer_File2.
 */
public class Consumer_File2 extends Consumer<Bean_File2> {

    Band       b_70, b_160, b_250, b_350, b_500;

    DaoFactory dao;

    /**
     * Instantiates a new consumer file 2.
     *
     * @param queue the queue
     */
    public Consumer_File2(QueueProducerConsumer<Bean_File2> queue) {
        super(queue);
        dao = DaoFactory.getInstance();
        try {
            b_70 = dao.getBandDao().getByBand(70);
            b_160 = dao.getBandDao().getByBand(160);
            b_250 = dao.getBandDao().getByBand(250);
            b_350 = dao.getBandDao().getByBand(350);
            b_500 = dao.getBandDao().getByBand(500);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * main.org.bdc.service.parser.monitor.consumers.Consumer#inserts(main.org.
     * bdc.service.parser.monitor.beans.SimpleBean)
     */
    @Override
    protected void inserts(Bean_File2 bean) {
        Clump clump;
        try {

            clump = dao.getClumpDao().getByIdOrNew(bean.getClumpId());
        } catch (Exception e) {
            clump = new Clump();
            clump.setId(bean.getClumpId());
            clump.setMap(new Map("Higal"));
        }

        List<Ellipse> ellipses = new ArrayList<>();
        //
        // clump.addFlow(new Flow(bean.getFlow_70(), b_70));
        // clump.addFlow(new Flow(bean.getFlow_160(), b_160));
        // clump.addFlow(new Flow(bean.getFlow_250(), b_250));
        // clump.addFlow(new Flow(bean.getFlow_350(), b_350));
        // clump.addFlow(new Flow(bean.getFlow_500(), b_500));

        clump.addEllipse(new Ellipse(bean.gethMaxAx_70(), bean.gethMinAx_70(), bean.getAlpha_70(), b_70, clump));
        clump.addEllipse(new Ellipse(bean.gethMaxAx_160(), bean.gethMinAx_160(), bean.getAlpha_160(), b_160, clump));
        clump.addEllipse(new Ellipse(bean.gethMaxAx_250(), bean.gethMinAx_250(), bean.getAlpha_250(), b_250, clump));
        clump.addEllipse(new Ellipse(bean.gethMaxAx_350(), bean.gethMinAx_350(), bean.getAlpha_350(), b_350, clump));
        clump.addEllipse(new Ellipse(bean.gethMaxAx_500(), bean.gethMinAx_500(), bean.getAlpha_500(), b_500, clump));
        try {
            dao.getClumpDao().saveOrUpdate(clump);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
