/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File3
 * Last update: 13-set-2017 15.11.30
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Flow;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Position;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File3;

/**
 * The Class Consumer_File3.
 */
public class Consumer_File3 extends Consumer<Bean_File3> {

    private Band       b_3d6, b_4d5, b_5d8, b_8d0;

    private DaoFactory dao;

    private Map        glimpse;

    /**
     * Instantiates a new consumer file 3.
     *
     * @param queue the queue
     */
    public Consumer_File3(QueueProducerConsumer<Bean_File3> queue) {
        super(queue);
        dao = DaoFactory.getInstance();
        try {
            b_3d6 = dao.getBandDao().getByBand(3.6);
            b_4d5 = dao.getBandDao().getByBand(4.5);
            b_5d8 = dao.getBandDao().getByBand(5.8);
            b_8d0 = dao.getBandDao().getByBand(8.0);
            glimpse = dao.getMapDao().getMapByName("Glimpse");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * main.org.bdc.service.parser.monitor.consumers.Consumer#inserts(main.org.
     * bdc.service.parser.monitor.beans.SimpleBean)
     */
    @Override
    protected void inserts(Bean_File3 bean) {
        Source source = new Source();
        source.setId(bean.getSourceId());
        source.addFlow(new Flow(bean.getFlow_3d6(), b_3d6));
        source.addFlow(new Flow(bean.getFlow_4d5(), b_4d5));
        source.addFlow(new Flow(bean.getFlow_5d8(), b_5d8));
        source.addFlow(new Flow(bean.getFlow_8d0(), b_8d0));
        source.setPosition(new Position(bean.getLatitude(), bean.getLongitude(), source));
        source.setMap(glimpse);
        try {
            dao.getSourceDao().saveOrUpdate(source);
        } catch (SaveOrUpdateDalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
