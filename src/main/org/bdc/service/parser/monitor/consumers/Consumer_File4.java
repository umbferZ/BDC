/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer_File4
 * Last update: 13-set-2017 0.30.06
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Flow;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.Bean_File4;

/**
 * The Class Consumer_File4.
 */
public class Consumer_File4 extends Consumer<Bean_File4> {

    private Band       b_24;

    private DaoFactory dao;

    /**
     * Instantiates a new consumer file 4.
     *
     * @param queue the queue
     */
    public Consumer_File4(QueueProducerConsumer<Bean_File4> queue) {
        super(queue);
        this.dao = DaoFactory.getInstance();
        try {
            this.b_24 = this.dao.getBandDao().getByBand(24.0);
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
    protected void inserts(Bean_File4 bean) {
        try {
            Source source = new Source();
            Source sourceToLowerBand;
            if (!bean.getSourceId_GLIMPSE().equals("")) {
                try {
                    sourceToLowerBand = this.dao.getSourceDao().getById(bean.getSourceId_GLIMPSE());
                } catch (Exception e) {
                    sourceToLowerBand = new Source();
                    sourceToLowerBand.setId(bean.getSourceId_GLIMPSE());
                    sourceToLowerBand.setMap(new Map("Glimpse"));
                }
                source.setSourceToLowerResolution(sourceToLowerBand);

            }
            source.setMap(new Map("MIPS-GAL"));
            source.setId(bean.getSourceId_MIPSGAL());
            source.addFlow(new Flow(bean.getFlow_24d0(), bean.getError_24d0(), this.b_24));
            this.dao.getSourceDao().saveOrUpdate(source);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
