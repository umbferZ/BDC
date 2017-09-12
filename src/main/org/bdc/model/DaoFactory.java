/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model
 * Type: DaoFactory
 * Last update: 13-set-2017 0.25.26
 * 
 */

package main.org.bdc.model;

import main.org.bdc.model.galaxy.dao.ClumpDao;
import main.org.bdc.model.galaxy.dao.EllipseDao;
import main.org.bdc.model.galaxy.dao.FlowDao;
import main.org.bdc.model.galaxy.dao.MapDao;
import main.org.bdc.model.galaxy.dao.SatelliteDao;
import main.org.bdc.model.galaxy.dao.SourceDao;
import main.org.bdc.model.instruments.dao.BandDao;
import main.org.bdc.model.instruments.dao.InstrumentDao;
import main.org.bdc.model.people.dao.UserDao;

/**
 * A factory for creating Dao objects.
 */
public class DaoFactory {

    private static DaoFactory instance = null;

    /**
     * Gets the single instance of DaoFactory.
     *
     * @return single instance of DaoFactory
     */
    public synchronized static DaoFactory getInstance() {
        if (instance == null)
            instance = new DaoFactory();
        return instance;
    }

    /**
     * Instantiates a new dao factory.
     */
    private DaoFactory() {}

    /**
     * Gets the band dao.
     *
     * @return the band dao
     */
    public BandDao getBandDao() {
        return new BandDao();
    }

    /**
     * Gets the clump dao.
     *
     * @return the clump dao
     */
    public ClumpDao getClumpDao() {
        return new ClumpDao();
    }

    /**
     * Gets the ellipse dao.
     *
     * @return the ellipse dao
     */
    public EllipseDao getEllipseDao() {
        return new EllipseDao();
    }

    /**
     * Gets the flow dao.
     *
     * @return the flow dao
     */
    public FlowDao getFlowDao() {
        return new FlowDao();
    }

    /**
     * Gets the instrument dao.
     *
     * @return the instrument dao
     */
    public InstrumentDao getInstrumentDao() {
        return new InstrumentDao();
    }

    public MapDao getMapDao() {
        return new MapDao();
    }

    /**
     * Gets the satellite dao.
     *
     * @return the satellite dao
     */
    public SatelliteDao getSatelliteDao() {
        return new SatelliteDao();
    }

    /**
     * Gets the source dao.
     *
     * @return the source dao
     */
    public SourceDao getSourceDao() {
        return new SourceDao();
    }

    /**
     * Gets the user dao.
     *
     * @return the user dao
     */
    public UserDao getUserDao() {
        return new UserDao();
    }
}