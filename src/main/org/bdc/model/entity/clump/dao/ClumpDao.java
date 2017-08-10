/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.entity.clump.dao
 * Type: ClumpDao
 * Last update: 12-mar-2017 15.54.43
 * 
 */

package main.org.bdc.model.entity.clump.dao;

import main.org.bdc.model.entity.Clump;
import main.org.bdc.service.dal.EntityDaoHibernate;

public class ClumpDao extends EntityDaoHibernate<Clump, Integer> {

    public double getAvgMassa() {
        return 0;
    }
}