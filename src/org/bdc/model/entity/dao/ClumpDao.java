/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.dao
 * Type: ClumpDao
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity.dao;

import org.bdc.model.entity.Clump;
import org.bdc.service.ddl.EntityDaoHibernate;

public class ClumpDao extends EntityDaoHibernate<Clump, Integer> {

    public double getAvgMassa() {
        // FIXME create criteria for determine avg value;
        return 0;
    }

}
