/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.dao
 * Type: ClumpDao
 * Last update: 9-set-2017 12.50.59
 * 
 */

package main.org.bdc.model.galaxy.dao;

import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class ClumpDao.
 */
public class ClumpDao extends EntityDaoHibernate<Clump, Integer> {

    /**
     * Gets the avg massa.
     *
     * @return the avg massa
     */
    public double getAvgMassa() {
        return 0;
    }

    /**
     * Gets the by id or new.
     *
     * @param idClump the id clump
     * @return the by id or new
     */
    public Clump getByIdOrNew(int idClump) {
        Clump clump;
        if ((clump = getById(idClump, true)) == null) {
            clump = new Clump();
            clump.setId(idClump);
        }
        return clump;

    }
}