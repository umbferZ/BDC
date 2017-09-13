/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.dao
 * Type: ClumpDao
 * Last update: 13-set-2017 19.21.15
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.List;

import javax.persistence.Query;

import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Flow;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class ClumpDao.
 */
public class ClumpDao extends EntityDaoHibernate<Clump, Integer> {

    public static void main(String[] args) {
        ClumpDao dao = new ClumpDao();
        try {
            List<Clump> list = dao.getClumpMass();
            int i = 0;
            for (Clump c : list)
                System.out.println(String.format("%d , c_id = %d, massa = %.10f flow= %.2f, temp = %.2f", i++, c.getId(), c.getMassa(), c.getFlows().get(3).getValue(), c.getClumpDetails().getTemperatura()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            System.out.println(String.format("AVG mass = %.2f", dao.getAvgMassa()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Gets the avg massa.
     *
     * @return the avg massa
     * @throws Exception
     */
    public double getAvgMassa() throws Exception {
        /**
         * select * from clump as c join clump_flow as cf on c.id = cf.clump_id
         * join flow as f on cf.flows_id = f.id join band as b on f.band_id=b.id
         * join clumpDetails cd on c.id = cd.clump_id where b.resolution = 350
         * and f.value >0
         */
        double avg = 0;
        List<Clump> clumps = getClumpMass();
        for (Clump c : getClumpMass())
            avg += c.getMassa();
        return avg / clumps.size();
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
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Clump> getClumpMass() throws Exception {
        /**
         * select * from clump as c join clump_flow as cf on c.id = cf.clump_id
         * join flow as f on cf.flows_id = f.id join band as b on f.band_id=b.id
         * join clumpDetails cd on c.id = cd.clump_id where b.resolution = 350
         * and f.value >0
         */

        String sql = "SELECT c FROM Clump c JOIN c.clumpDetails cd JOIN c.flows f WHERE f.band.resolution = 350 and f.value > 0";
        Query query = super.openSession().createQuery(sql);
        List<Clump> clumps = query.getResultList();
        closeSession();
        if (clumps.size() > 0) {
            for (Clump c : clumps)
                for (Flow f : c.getFlows())
                    if (f.getBanda().getResolution() == 350) {
                        c.setMassa(0.053 * f.getValue() * 100 * Math.exp(41.14 / c.getClumpDetails().getTemperatura() - 1));
                        break;
                    }
            return clumps;
        }
        throw new Exception("No elements");
    }
}