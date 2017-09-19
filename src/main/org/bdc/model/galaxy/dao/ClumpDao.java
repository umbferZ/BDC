/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.dao
 * Type: ClumpDao
 * Last update: 15-set-2017 15.16.40
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.math.BigDecimal;
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

    /* Show all Clumps */
    public List<Clump> showClumps() throws Exception {
        String sql = "SELECT * FROM Clump";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Clump> clumps = new ArrayList<>();
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            clumps.add(clump);
        }
        return clumps;
    }

    /**
     * Gets the avg massa.
     *
     * @return the avg massa
     * @throws Exception
     */

    /* REQ 10.1 */
    public double getAvgMassa() throws Exception {

        String sql = "SELECT AVG(q.mass) avg " +
                "FROM " +
                "( " +
                "SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) mass " +
                "from clump as c join clump_flow as cf on c.id = cf.clump_id " +
                "join flow as f on cf.flows_id = f.id " +
                "join band as b on f.band_id=b.id " +
                "join clumpDetails cd on c.id = cd.clump_id " +
                "where b.resolution = 350 " +
                "and f.value >0 order by mass " +
                ") AS q;";

        Query query = super.openSession().createNativeQuery(sql);
        double clumps = (double) query.getSingleResult();
        closeSession();
        System.out.println(clumps);
        return clumps;
    }

    /* REQ 10.1 */
    public double getStdDevMassa() throws Exception {

        String sql = "SELECT STDDEV(q.mass) stddev " +
                "FROM " +
                "( " +
                "SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) mass " +
                "from clump as c join clump_flow as cf on c.id = cf.clump_id " +
                "join flow as f on cf.flows_id = f.id " +
                "join band as b on f.band_id=b.id " +
                "join clumpDetails cd on c.id = cd.clump_id " +
                "where b.resolution = 350 " +
                "and f.value >0 order by mass " +
                ") AS q;";

        Query query = super.openSession().createNativeQuery(sql);
        double clumps = (double) query.getSingleResult();
        closeSession();
        System.out.println(clumps);
        return clumps;
    }

    /* REQ 10.1 */
    public double getMedian() throws Exception {

        String sql = "SELECT  mass median " +
                "from ( " +
                "SELECT a1.id, a1.mass, COUNT(a1.mass) Rank " +
                "FROM " +
                "( " +
                "SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) mass " +
                "from clump as c join clump_flow as cf on c.id = cf.clump_id " +
                "join flow as f on cf.flows_id = f.id " +
                "join band as b on f.band_id=b.id " +
                "join clumpDetails cd on c.id = cd.clump_id " +
                "where b.resolution = 350 " +
                "and f.value >0 order by mass " +
                ")AS a1, " +
                "( " +
                "SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) mass " +
                "from clump as c join clump_flow as cf on c.id = cf.clump_id " +
                "join flow as f on cf.flows_id = f.id " +
                "join band as b on f.band_id=b.id " +
                "join clumpDetails cd on c.id = cd.clump_id " +
                "where b.resolution = 350 " +
                "and f.value >0 order by mass " +
                ") AS a2 " +
                "WHERE a1.mass < a2.mass OR (a1.mass=a2.mass AND a1.id<=a2.id) " +
                "GROUP BY a1.id, a1.mass " +
                "ORDER BY a1.mass desc " +
                ") AS a3 " +
                "WHERE Rank = ( " +
                "Select (count(*) +1) / 2 " +
                "from " +
                "( " +
                "SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) mass " +
                "from clump as c join clump_flow as cf on c.id = cf.clump_id " +
                "join flow as f on cf.flows_id = f.id " +
                "join band as b on f.band_id=b.id " +
                "join clumpDetails cd on c.id = cd.clump_id " +
                "where b.resolution = 350 " +
                "and f.value >0 order by mass " +
                ") as a4 " +
                ")";

        Session s = super.openSession();
        org.hibernate.Transaction t = s.beginTransaction();
        Query query = s.createNativeQuery(sql);
        double median = (double) query.getSingleResult();
        t.commit();
        closeSession();
        return median;

    }

    /* REQ 10.1 */
    public double getMADMassa() throws Exception {

        String sql = "SELECT STDDEV(q.mass)*0.67449 mad " +
                "FROM " +
                "( " +
                "SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) mass " +
                "from clump as c join clump_flow as cf on c.id = cf.clump_id " +
                "join flow as f on cf.flows_id = f.id " +
                "join band as b on f.band_id=b.id " +
                "join clumpDetails cd on c.id = cd.clump_id " +
                "where b.resolution = 350 " +
                "and f.value >0 order by mass " +
                ") AS q;";

        Query query = super.openSession().createNativeQuery(sql);
        double clumps = (double) query.getSingleResult();
        closeSession();
        System.out.println(clumps);
        return clumps;
    }

    /* REQ 05 */
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

    /* REQ 05 */
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

    /* REQ 08 */
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

    /* REQ 08 */
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

    /* REQ 10 */
    public List<Clump> getClumpMass() throws Exception {

        String sql2 = "SELECT c.id, 0.053*f.value*100*(EXP(41.14/cd.temperatura-1)) mass " +
                "from clump as c join clump_flow as cf on c.id = cf.clump_id " +
                "join flow as f on cf.flows_id = f.id " +
                "join band as b on f.band_id=b.id " +
                "join clumpDetails cd on c.id = cd.clump_id " +
                "where b.resolution = 350 " +
                "and f.value >0 order by mass;";

        Query query = super.openSession().createNativeQuery(sql2);
        List<Object[]> rows = query.getResultList();
        closeSession();
        List<Clump> clumps = new ArrayList();
        if (rows.size() < 1)
            throw new Exception("No Elements!");
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            clump.setMassa((double) o[1]);
            clumps.add(clump);
            System.out.println(String.format("%s %s", o[0], o[1]));
        }
        return clumps;

    }

    /* REQ 07 */
    public List<Clump> getClumpDensity() throws Exception {

        String sql2 = "SELECT w1.clump_id, (w1.n_stars*1.0)/(w2.n_sources*1.0)*1.0 fraction\n" +
                "\n" +
                "FROM\n" +
                "(\n" +
                "\tSELECT r.clump_id, COUNT(*) n_stars\n" +
                "\tFROM\n" +
                "\t(\n" +
                "\t\tSELECT s.id, p.latitude, p.longitude, (p.latitude^2-q.lat^2)+(p.longitude^2-q.lon^2) distance, q.ass, q.c_z_id clump_id\n" +
                "\t\tFROM source s\n" +
                "\t\tJOIN position p ON p.source_id = s.id\n" +
                "\t\tJOIN map m ON m.id = s.map_id\n" +
                "\t\tCROSS JOIN \n" +
                "\t\t(\n" +
                "\t\t\tSELECT distinct cd.lat lat, cd.lon lon, e.xass ass, c.id c_z_id\n" +
                "\t\t\tFROM clump c\n" +
                "\t\t\tJOIN clumpdetails cd ON c.id = cd.clump_id\n" +
                "\t\t\tJOIN ellipse e ON c.id = e.clump_id\n" +
                "\t\t\tJOIN band b ON b.id = e.band_id\n" +
                "\t\t\tAND cd.densita BETWEEN 0.1 AND  1.0\n" +
                "\t\t) AS q\n" +
                "\n" +
                "\t\tWHERE s.id NOT IN  (\n" +
                "\t\t\tSELECT id\n" +
                "\t\t\tFROM source\n" +
                "\t\t\tWHERE sourcetolowerresolution_id IN\n" +
                "\t\t\t(\n" +
                "\t\t\t\tSELECT DISTINCT sf_z.source_id\n" +
                "\t\t\t\tFROM source_flow sf_z\n" +
                "\t\t\t\t JOIN(\n" +
                "\t\t\t\t\tSELECT sf1.source_id, f1.value flux_4d5\n" +
                "\t\t\t\t\tFROM source_flow sf1\n" +
                "\t\t\t\t\tJOIN flow f1 ON f1.id = sf1.flows_id \n" +
                "\t\t\t\t\tJOIN band b1 ON b1.id = f1.band_id AND b1.resolution = 4.5\n" +
                "\t\t\t\t) AS q1 ON sf_z.source_id = q1.source_id\n" +
                "\t\t\t\tJOIN(\n" +
                "\t\t\t\t\tSELECT sf1.source_id, f1.value flux_3d6\n" +
                "\t\t\t\t\tFROM source_flow sf1\n" +
                "\t\t\t\t\tJOIN flow f1 ON f1.id = sf1.flows_id \n" +
                "\t\t\t\t\tJOIN band b1 ON b1.id = f1.band_id AND b1.resolution = 3.6\n" +
                "\t\t\t\t\tWHERE f1.value > 0\n" +
                "\t\t\t\t) AS q2 ON sf_z.source_id = q2.source_id\n" +
                "\t\t\t\tJOIN(\n" +
                "\t\t\t\t\tSELECT sf1.source_id, f1.value flux_5d8\n" +
                "\t\t\t\t\tFROM source_flow sf1\n" +
                "\t\t\t\t\tJOIN flow f1 ON f1.id = sf1.flows_id \n" +
                "\t\t\t\t\tJOIN band b1 ON b1.id = f1.band_id AND b1.resolution = 5.8\n" +
                "\t\t\t\t) AS q3 ON sf_z.source_id = q3.source_id\n" +
                "\t\t\t\tWHERE flux_4d5 - flux_5d8 > 0.7\n" +
                "\t\t\t\tAND flux_3d6 - flux_4d5 > 0.7\n" +
                "\t\t\t\tAND flux_3d6 - flux_4d5 > 1.4*(flux_4d5 - flux_5d8 -0.7) + 0.15\n" +
                "\t\t\t)\n" +
                "\t\t)\n" +
                "\t\t\n" +
                "\t)as r\n" +
                "\tWHERE r.distance < r.ass\n" +
                "\tGROUP BY r.clump_id\n" +
                ") as w1\n" +
                "JOIN (\n" +
                "SELECT r.clump_id, COUNT(*) n_sources\n" +
                "\tFROM\n" +
                "\t(\n" +
                "\t\tSELECT s.id, p.latitude, p.longitude, (p.latitude^2-q.lat^2)+(p.longitude^2-q.lon^2) distance, q.ass, q.c_z_id clump_id\n" +
                "\t\tFROM source s\n" +
                "\t\tJOIN position p ON p.source_id = s.id\n" +
                "\t\tJOIN map m ON m.id = s.map_id\n" +
                "\t\tCROSS JOIN \n" +
                "\t\t(\n" +
                "\t\t\tSELECT distinct cd.lat lat, cd.lon lon, e.xass ass, c.id c_z_id\n" +
                "\t\t\tFROM clump c\n" +
                "\t\t\tJOIN clumpdetails cd ON c.id = cd.clump_id\n" +
                "\t\t\tJOIN ellipse e ON c.id = e.clump_id\n" +
                "\t\t\tJOIN band b ON b.id = e.band_id\n" +
                "\t\t\tAND cd.densita BETWEEN 0.1 AND  1.0\n" +
                "\t\t) AS q\t\t\n" +
                "\t)as r\n" +
                "\tWHERE r.distance < r.ass\n" +
                "\tGROUP BY r.clump_id\n" +
                "\n" +
                ")as w2 ON w1.clump_id = w2.clump_id\n" +
                "ORDER BY fraction";

        Query query = super.openSession().createNativeQuery(sql2);
        List<Object[]> rows = query.getResultList();
        closeSession();
        List<Clump> clumps = new ArrayList();
        if (rows.size() < 1)
            throw new Exception("No Elements!");
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            clump.setFraction((BigDecimal) o[1]);
            clumps.add(clump);
        }
        return clumps;

    }

    /* REQ 06 */
    public List<Clump> getClumpByID(int id) throws Exception {
        String sql2 = "SELECT cf.clump_id, f.value, b.resolution, cd.lat, cd.lon\n" +
                "FROM clump_flow as cf\n" +
                "INNER JOIN flow as f on f.id = cf.flows_id\n" +
                "INNER JOIN band as b on b.id = f.band_id\n" +
                "INNER JOIN clumpDetails cd on cd.clump_id = cf.clump_id\n" +
                "WHERE f.value > 0 \n" +
                "AND cf.clump_id = :c_id\n";

        Query query = super.openSession().createNativeQuery(sql2);
        query.setParameter("c_id", id);
        List<Object[]> rows = query.getResultList();
        closeSession();
        List<Clump> clumps = new ArrayList();
        if (rows.size() < 1)
            throw new Exception("No Elements!");
        for (Object[] o : rows) {
            Clump clump = new Clump();
            clump.setId((int) o[0]);
            ClumpDetails clumpDetails = new ClumpDetails();
            clumpDetails.setLat((double) o[3]);
            clumpDetails.setLon((double) o[4]);
            clump.setClumpDetails(clumpDetails);
            Flow flow = new Flow();
            flow.setValue((double) o[1]);
            flow.setBanda(new Band((double) o[2]));
            clump.addFlow(flow);
            clumps.add(clump);
        }
        return clumps;
    }

}