/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.dao
 * Type: FlowDao
 * Last update: 15-set-2017 15.26.34
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import main.org.bdc.model.galaxy.Flow;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.service.dal.EntityDaoHibernate;

public class FlowDao extends EntityDaoHibernate<Flow, Integer> {

    public List<Flow> getFlows(int clumpid) throws Exception {
        String sql2 = "Select cf.clump_id, f.value, b.resolution from clump_flow as cf join flow as f on f.id = cf.flows_id join band as b on b.id = f.band_id WHERE f.value>0 AND cf.clump_id = :clump_id";

        Query query = super.openSession().createNativeQuery(sql2);
        List<Object[]> rows = query.getResultList();
        query.setParameter("clump_id", clumpid);
        closeSession();
        List<Flow> flows = new ArrayList();
        if (rows.size() < 1)
            throw new Exception("No elements");
        for (Object[] o : rows) {
            Flow flow = new Flow();
            Band band = new Band();
            flow.setValue((double) o[1]);
            flow.setBanda(band);
            band.setResolution((double) o[2]);
            flows.add(flow);
        }
        return flows;

    }

}
