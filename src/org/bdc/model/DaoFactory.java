/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model
 * Type: DaoFactory
 * Last update: 10-mar-2017 15.47.04
 * 
 */

package org.bdc.model;

import org.bdc.model.entity.clump.dao.ClumpDao;
import org.bdc.model.entity.satelliti.dao.BandaDao;
import org.bdc.model.entity.satelliti.dao.SatelliteDao;
import org.bdc.model.entity.satelliti.dao.StrumentoDao;

public class DaoFactory {

    private static DaoFactory instance = null;

    public static DaoFactory getInstance() {

        if (instance == null)
            instance = new DaoFactory();
        return instance;
    }

    private DaoFactory() {

    }

    public BandaDao getBandaDao() {

        return new BandaDao();
    }

    public ClumpDao getClumpDao() {

        return new ClumpDao();
    }

    public SatelliteDao getSatelliteDao() {

        return new SatelliteDao();
    }

    public StrumentoDao getStrumentoDao() {

        return new StrumentoDao();
    }
}
