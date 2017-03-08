/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model
 * Type: DaoFactory
 * Last update: 8-mar-2017 14.11.14
 * 
 */
package org.bdc.model;

import org.bdc.model.entity.dao.ClumpDao;
import org.bdc.model.entity.dao.SatelliteDao;
import org.bdc.model.entity.dao.StrumentoDao;

public class DaoFactory {

    private static DaoFactory instance = null;

    public static DaoFactory getInstance() {
        if (instance == null)
            instance = new DaoFactory();
        return instance;
    }

    private DaoFactory() {

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
