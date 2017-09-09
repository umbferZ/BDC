/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.dao
 * Type: BandaDao
 * Last update: 8-set-2017 18.18.27
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import main.org.bdc.model.galaxy.Band;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class BandaDao.
 */
public class BandaDao extends EntityDaoHibernate<Band, Integer> {

    public Band getByBand(double resolution) throws Exception {

        String sql = "FROM Band WHERE risoluzione=:risoluzione";
        TypedQuery<Band> query = getSession().createQuery(sql);
        query.setParameter("risoluzione", resolution);

        List<Band> bands = query.getResultList();
        closeSession();
        if (bands.size() == 1)
            return bands.get(0);
        throw new Exception("Error in band");

    }
}
