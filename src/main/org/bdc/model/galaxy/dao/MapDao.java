/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.dao
 * Type: MapDao
 * Last update: 12-set-2017 17.31.41
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.org.bdc.model.galaxy.Map;
import main.org.bdc.service.dal.EntityDaoHibernate;

public class MapDao extends EntityDaoHibernate<Map, Integer> {

    public Map getMapByName(String name) throws Exception {
        String sql = "FROM Map WHERE name= :name";
        Session s = getSession();
        Query query = s.createQuery(sql);
        query.setParameter("name", name);
        List<Map> maps = query.getResultList();
        closeSession();
        if (maps.size() == 1)
            return maps.get(0);
        throw new Exception("No map");
    }

}
