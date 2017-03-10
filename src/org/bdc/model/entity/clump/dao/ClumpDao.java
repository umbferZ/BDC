/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.clump.dao
 * Type: ClumpDao
 * Last update: 10-mar-2017 15.47.04
 * 
 */

package org.bdc.model.entity.clump.dao;

import org.bdc.model.entity.Clump;
import org.bdc.service.ddl.EntityDaoHibernate;

public class ClumpDao extends EntityDaoHibernate<Clump, Integer> {

    public double getAvgMassa() {

        // FIXME create criteria for determine avg value;
        return 0;
    }

}
