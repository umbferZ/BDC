/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.dao
 * Type: ClumpDao
 * Last update: 15-set-2017 6.49.39
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.ClumpDetails;
import main.org.bdc.model.galaxy.Flow;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class ClumpDao.
 */
public class ClumpDao extends EntityDaoHibernate<Clump, Integer> {

    public static void main(String[] args) {

        try {
            for (Clump s : DaoFactory.getInstance().getClumpDao().getByPositionIntoRound(0, 0, 0.2, 20))
                System.out.println(String.format("%s, %.2f, %.2f", s.getId(), s.getClumpDetails().getLat(), s.getClumpDetails().getLon()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
    }

    /**
     * Gets the avg massa.
     *
     * @return the avg massa
     * @throws Exception
     */
    public double getAvgMassa() throws Exception {
        String sql = "select avg(0.053*f.value*100*(EXP(41.14/cd.temperatura-1))) from clump as c join clump_flow as cf on c.id = cf.clump_id join flow as f on cf.flows_id = f.id join band as b on f.band_id=b.id join clumpDetails cd on c.id = cd.clump_id  where b.resolution = 350 and f.value >0";
        Query query = super.openSession().createNativeQuery(sql);
        double clumps = (double) query.getSingleResult();
        closeSession();
        System.out.println(clumps);
        return clumps;
    }

    public Clump getById() {
        return new Clump();
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

    public List<Clump> getByMap(String mapType, int offset) throws Exception {
        String sql = "SELECT cf.clump_id, f1.value, b1.resolution  FROM clump_flow cf JOIN flow f1 ON f1.id = cf.flows_id JOIN band b1 ON b1.id = f1.band_id WHERE cf.flows_id IN (  SELECT f.id  FROM flow AS f  JOIN band AS b ON f.band_id = b.id  JOIN instrument AS i ON b.instrument_id = i.id  JOIN map AS m ON m.id = i.map_id  WHERE m.name like :map  AND f.value > 0 ) LIMIT 50 OFFSET :offset";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("map", mapType);
        query.setParameter("offset", offset);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Clump> clumps = new ArrayList<>();
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            Band b = new Band();
            b.setResolution((double) o[2]);
            Flow flow = new Flow((double) o[1], b);
            clump.addFlow(flow);
            clumps.add(clump);
        }
        return clumps;
    }

    public List<Clump> getByMap(String mapType, int offset, double band) throws Exception {
        String sql = "SELECT cf.clump_id, f1.value, b1.resolution  FROM clump_flow cf JOIN flow f1 ON f1.id = cf.flows_id JOIN band b1 ON b1.id = f1.band_id WHERE cf.flows_id IN (  SELECT f.id  FROM flow AS f  JOIN band AS b ON f.band_id = b.id  JOIN instrument AS i ON b.instrument_id = i.id  JOIN map AS m ON m.id = i.map_id  WHERE m.name like :map  AND f.value > 0  AND b.resolution = :band ) LIMIT 50 OFFSET :offset";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("map", mapType);
        query.setParameter("offset", offset);
        query.setParameter("band", band);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Clump> clumps = new ArrayList<>();
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            Band b = new Band();
            b.setResolution((double) o[2]);
            Flow flow = new Flow((double) o[1], b);
            clump.addFlow(flow);
            clumps.add(clump);
        }
        return clumps;
    }

    public List<Clump> getByPositionIntoRound(double latitude, double longitude, double distance, int limit) throws Exception {
        String sql = "SELECT * FROM (SELECT c.id, cd.lat  lat, cd.lon lon, ACOS(SIN(:lat)*SIN(lat)+COS(:lat)*COS(lat)*COS(:lon-lon)) distance FROM clump AS c JOIN clumpDetails as cd ON c.id = cd.clump_id ) AS q WHERE distance < :d Order BY distance asc LIMIT :l";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("lat", latitude);
        query.setParameter("lon", longitude);
        query.setParameter("d", distance);
        query.setParameter("l", limit);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Clump> clumps = new ArrayList<>();
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            clump.setDistance((double) o[3]);
            ClumpDetails cd = new ClumpDetails();
            cd.setClump(clump);
            cd.setLat((double) o[1]);
            cd.setLon((double) o[2]);
            clump.setClumpDetails(cd);
            clumps.add(clump);
        }
        return clumps;
    }

    public List<Clump> getByPositionIntoSquare(double latitude, double longitude, double distance, int limit) throws Exception {
        String sql = "SELECT c.id, cd.lat, cd.lon, SQRT((cd.lat^2-:lat^2)+(cd.lon^2-:lon^2)) distance FROM clump AS c JOIN clumpDetails as cd ON c.id = cd.clump_id WHERE cd.lat BETWEEN :lat-:d/SQRT(2) AND :lat+:d/SQRT(2) AND cd.lon BETWEEN :lon-:d/SQRT(2) AND :lon+:d/SQRT(2) ORDER BY distance ASC LIMIT :l";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("lat", latitude);
        query.setParameter("lon", longitude);
        query.setParameter("d", distance);
        query.setParameter("l", limit);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Clump> clumps = new ArrayList<>();
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            clump.setDistance((double) o[3]);
            ClumpDetails cd = new ClumpDetails();
            cd.setClump(clump);
            cd.setLat((double) o[1]);
            cd.setLon((double) o[2]);
            clump.setClumpDetails(cd);
            clumps.add(clump);
        }
        return clumps;
    }

    public List<Clump> getClumpMass() throws Exception {
        String sql2 = "select c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) massa from clump as c join clump_flow as cf on c.id = cf.clump_id join flow as f on cf.flows_id = f.id join band as b on f.band_id=b.id join clumpDetails cd on c.id = cd.clump_id where b.resolution = 350 and f.value >0";

        Query query = super.openSession().createNativeQuery(sql2);
        List<Object[]> rows = query.getResultList();
        closeSession();
        List<Clump> clumps = new ArrayList();
        if (rows.size() < 1)
            throw new Exception("No elements");
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setMassa((double) o[1]);
            clumps.add(clump);
            System.out.println(String.format("%s %s", o[0], o[1]));
        }
        return clumps;

    }

    public double getMedian() throws Exception {
        // CREATE OR REPLACE VIEW tabMasse AS
        // SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) masse
        // from clump as c join clump_flow as cf on c.id = cf.clump_id
        // join flow as f on cf.flows_id = f.id
        // join band as b on f.band_id=b.id
        // join clumpDetails cd on c.id = cd.clump_id
        // where b.resolution = 350
        // and f.value >0 order by masse;
        //
        // SELECT masse median from (
        // SELECT a1.id, a1.masse, COUNT(a1.masse) Rank
        // FROM tabMasse a1, tabMasse a2
        // WHERE a1.masse < a2.masse OR (a1.masse=a2.masse AND a1.id<=a2.id)
        // GROUP BY a1.id, a1.masse
        // ORDER BY a1.masse desc
        // ) a3
        // WHERE Rank = (
        // Select (count(*) +1) / 2 from tabMasse);

        String sql = "CREATE OR REPLACE VIEW tabMasse AS SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) masse from clump as c join clump_flow as cf on c.id = cf.clump_id join flow as f on cf.flows_id = f.id join band as b on f.band_id=b.id join clumpDetails cd on c.id = cd.clump_id where b.resolution = 350 and f.value >0 order by masse; SELECT  masse median from (SELECT a1.id, a1.masse, COUNT(a1.masse) Rank FROM tabMasse a1, tabMasse a2 WHERE a1.masse < a2.masse OR (a1.masse=a2.masse AND a1.id<=a2.id) GROUP BY a1.id, a1.masse ORDER BY a1.masse desc ) a3 WHERE Rank = (Select (count(*) +1) / 2from tabMasse);";
        Session s = super.openSession();
        org.hibernate.Transaction t = s.beginTransaction();
        Query query = s.createNativeQuery(sql);
        double median = (double) query.getSingleResult();
        t.commit();
        closeSession();
        return median;

    }

}