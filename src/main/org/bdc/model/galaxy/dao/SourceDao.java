/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.dao
 * Type: SourceDao
 * Last update: 13-set-2017 0.26.59
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import main.org.bdc.model.galaxy.Source;
import main.org.bdc.service.dal.EntityDaoHibernate;

public class SourceDao extends EntityDaoHibernate<Source, Integer> {

    public Source getById(String id) throws Exception {
        String sql = "FROM Source WHERE id=:id";
        TypedQuery<Source> query = getSession().createQuery(sql);
        query.setParameter("id", id);
        List<Source> sources = query.getResultList();
        closeSession();
        if (sources.size() == 1)
            return sources.get(0);
        throw new Exception("Error in sources");
    }

    public List<Source> getByPositionIntoSqure(double latitude, double longitude, double distance, int limit) {
        // TODO Auto-generated method stub
        return null;
    }

}
