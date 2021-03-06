/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.dao
 * Type: MapDao
 * Last update: 20-set-2017 13.23.21
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.List;

import javax.persistence.Query;

import main.org.bdc.model.galaxy.Map;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class MapDao.
 */
public class MapDao extends EntityDaoHibernate<Map, Integer> {

    /**
     * Gets the map by name.
     *
     * @param name the name
     * @return the map by name
     * @throws Exception the exception
     */
    public Map getMapByName(String name) throws Exception {
        String sql = "FROM Map WHERE name= :name";
        Query query = super.openSession().createQuery(sql);
        query.setParameter("name", name);
        List<Map> maps = query.getResultList();
        closeSession();
        if (maps.size() == 1)
            return maps.get(0);
        throw new Exception("No Map Available!");
    }

}
