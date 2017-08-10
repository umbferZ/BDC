/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model
 * Type: DaoFactory
 * Last update: 12-mar-2017 16.23.00
 * 
 */

package main.org.bdc.model;

import main.org.bdc.model.entity.clump.dao.ClumpDao;
import main.org.bdc.model.entity.satelliti.dao.BandaDao;
import main.org.bdc.model.entity.satelliti.dao.SatelliteDao;
import main.org.bdc.model.entity.satelliti.dao.StrumentoDao;
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
    public static DaoFactory getInstance() {
        if (instance == null)
            instance = new DaoFactory();
        return instance;
    }

    /**
     * Instantiates a new dao factory.
     */
    private DaoFactory() {}

    /**
     * Gets the banda dao.
     *
     * @return the banda dao
     */
    public BandaDao getBandaDao() {
        return new BandaDao();
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
     * Gets the satellite dao.
     *
     * @return the satellite dao
     */
    public SatelliteDao getSatelliteDao() {
        return new SatelliteDao();
    }

    /**
     * Gets the strumento dao.
     *
     * @return the strumento dao
     */
    public StrumentoDao getStrumentoDao() {
        return new StrumentoDao();
    }

    /**
     * Gets the utente dao.
     *
     * @return the utente dao
     */
    public UserDao getUserDao() {
        return new UserDao();
    }
}