/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.dao
 * Type: ClumpDao
 * Last update: 8-set-2017 18.11.22
 * 
 */

package main.org.bdc.model.galaxy.dao;

import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.service.dal.EntityDaoHibernate;

public class ClumpDao extends EntityDaoHibernate<Clump, Integer> {

    public double getAvgMassa() {
        return 0;
    }

    public Clump getByIdOrNew(int idClump) {
        Clump clump;
        if ((clump = getById(idClump, true)) == null) {
            clump = new Clump();
            clump.setId(idClump);
        }
        return clump;

    }
}