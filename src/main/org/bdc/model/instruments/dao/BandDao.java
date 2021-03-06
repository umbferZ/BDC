/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.instruments.dao
 * Type: BandDao
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.model.instruments.dao;

import java.util.List;

import javax.persistence.Query;

import main.org.bdc.model.instruments.Band;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class BandDao.
 */
public class BandDao extends EntityDaoHibernate<Band, Integer> {

    /**
     * Gets the by band.
     *
     * @param resolution the resolution
     * @return the by band
     * @throws Exception the exception
     */
    public Band getByBand(double resolution) throws Exception {

        String sql = "FROM Band WHERE resolution= :resolution";
        Query query = super.openSession().createQuery(sql);
        query.setParameter("resolution", resolution);
        List<Band> bands = query.getResultList();
        closeSession();
        if (bands.size() == 1)
            return bands.get(0);
        throw new Exception("Error in band");

    }
}
