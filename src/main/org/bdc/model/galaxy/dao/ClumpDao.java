/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.dao
 * Type: ClumpDao
 * Last update: 12-set-2017 18.52.39
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.List;

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

    public List<Clump> getByPositionIntoSquare(double latitude, double longitude, double distance, int limit) {
        String query = "FROM Clump JOIN ClumpDetails WHERE latidude BETWEEN :latitudeMin AND :latitudeMax AND longitude BETWEEN :longitudeMax AND longitudeMin";
        // TODO Auto-generated method stub
        return null;
    }
}