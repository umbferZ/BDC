/*
 *
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model
 * Type: DaoFactory
 * Last update: 8-set-2017 15.58.17
 *
 */

package main.org.bdc.model;

import main.org.bdc.model.galaxy.dao.BandaDao;
import main.org.bdc.model.galaxy.dao.ClumpDao;
import main.org.bdc.model.galaxy.dao.SatelliteDao;
import main.org.bdc.model.galaxy.dao.StrumentoDao;
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
     * Gets the instrument dao.
     *
     * @return the instrument dao
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