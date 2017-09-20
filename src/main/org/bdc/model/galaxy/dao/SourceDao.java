/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.dao
 * Type: SourceDao
 * Last update: 15-set-2017 6.46.32
 * 
 */

package main.org.bdc.model.galaxy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Flow;
import main.org.bdc.model.galaxy.Position;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class SourceDao.
 */
public class SourceDao extends EntityDaoHibernate<Source, Integer> {

    /**
     * The main method.
     *
     * @param args the arguments
     */

    /* MAIN DI PROVA */
    public static void main(String[] args) {
        try {
            List<Source> sources = DaoFactory.getInstance().getSourceDao().getByMap("Glimpse", 1, 3.6);
            for (Source s : sources)
                System.out.println(String.format("%s", s.getId()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     * @throws Exception the exception
     */

    /* Get Sources by ID */
    public Source getById(String id) throws Exception {
        String sql = "FROM Source WHERE id=:id";
        TypedQuery<Source> query = getSession().createQuery(sql);
        query.setParameter("id", id);
        List<Source> sources = query.getResultList();
        closeSession();
        if (sources.size() == 1)
            return sources.get(0);
        throw new Exception("Error in sources");
    }

    /**
     * Gets the by map.
     *
     * @param mapType the map type
     * @param offset the offset
     * @return the by map
     * @throws Exception the exception
     */

    /* REQ 05 */
    public List<Source> getByMap(String mapType, int offset) throws Exception {
        String sql = "SELECT sf.source_id, f1.value , b1.resolution FROM source_flow sf JOIN flow f1 ON f1.id = sf.flows_id JOIN band b1 ON b1.id = f1.band_id WHERE sf.flows_id IN (SELECT f.id FROM flow AS f JOIN band AS b ON f.band_id = b.id JOIN instrument AS i ON b.instrument_id = i.id JOIN map AS m ON m.id = i.map_id WHERE m.name like :map AND f.value > 0 ) LIMIT 50 OFFSET :offset";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("map", mapType);
        query.setParameter("offset", offset);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Source> sources = new ArrayList<>();
        for (Object[] o : rows) {
            Source source = new Source();
            source.setId((String) o[0]);
            Band b = new Band();
            b.setResolution((double) o[2]);
            Flow flow = new Flow((double) o[1], b);
            source.addFlow(flow);
            sources.add(source);
        }
        return sources;
    }

    /**
     * Gets the by map.
     *
     * @param mapType the map type
     * @param offset the offset
     * @param band the band
     * @return the by map
     * @throws Exception the exception
     */

    /* REQ 05 */
    public List<Source> getByMap(String mapType, int offset, double band) throws Exception {
        String sql = "SELECT sf.source_id, f1.value , b1.resolution FROM source_flow sf JOIN flow f1 ON f1.id = sf.flows_id JOIN band b1 ON b1.id = f1.band_id WHERE sf.flows_id IN (SELECT f.id FROM flow AS f JOIN band AS b ON f.band_id = b.id JOIN instrument AS i ON b.instrument_id = i.id JOIN map AS m ON m.id = i.map_id WHERE m.name like :map AND f.value > 0 AND b.resolution = :band ) LIMIT 50 OFFSET :offset";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("map", mapType);
        query.setParameter("offset", offset);
        query.setParameter("band", band);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Source> sources = new ArrayList<>();
        for (Object[] o : rows) {
            Source source = new Source();
            source.setId((String) o[0]);
            Band b = new Band();
            b.setResolution((double) o[2]);
            Flow flow = new Flow((double) o[1], b);
            source.addFlow(flow);
            sources.add(source);
        }
        return sources;
    }

    /**
     * Gets the by position into round.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @param distance the distance
     * @param limit the limit
     * @return the by position into round
     * @throws Exception the exception
     */

    /* REQ 08 */
    public List<Source> getByPositionIntoRound(double latitude, double longitude, double distance, int limit) throws Exception {
        String sql = "SELECT * FROM (SELECT s.id, p.latitude lat, p.longitude AS lon, ACOS(SIN(:lat)*SIN(latitude)+COS(:lat)*COS(latitude)*COS(:lon-longitude)) distance FROM source AS s JOIN position as p ON s.id = p.source_id) AS q WHERE distance < :d ORDER BY distance ASC LIMIT :l";
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
        List<Source> sources = new ArrayList<>();
        for (Object[] o : rows) {
            Source source = new Source();
            source.setId((String) o[0]);
            source.setDistance((double) o[3]);
            Position p = new Position((double) o[1], (double) o[2], source);
            source.setPosition(p);
            sources.add(source);
        }
        return sources;
    }

    /**
     * Gets the by position into squre.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @param distance the distance
     * @param limit the limit
     * @return the by position into squre
     * @throws Exception the exception
     */

    /* REQ 08 */
    public List<Source> getByPositionIntoSqure(double latitude, double longitude, double distance, int limit) throws Exception {
        String sql = "SELECT s.id, p.latitude, p.longitude,SQRT((p.latitude^2-:lat^2)+(p.longitude^2-:lon^2)) distance FROM source AS s JOIN position AS p ON (s.id = p.source_id) WHERE p.latitude BETWEEN :lat-:d/SQRT(2) AND :lat+:d/SQRT(2) AND p.longitude BETWEEN :lon-:d/SQRT(2) AND :lon+:d/SQRT(2) ORDER BY distance limit :l";
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
        List<Source> sources = new ArrayList<>();
        for (Object[] o : rows) {
            Source source = new Source();
            source.setId((String) o[0]);
            source.setDistance((double) o[3]);
            Position p = new Position((double) o[1], (double) o[2], source);
            source.setPosition(p);
            sources.add(source);
        }
        return sources;
    }

    /* REQ 09 */
    public List<Source> getSourceInClump(int clumpid, double bandResolution) throws Exception {
        String sql = "SELECT * FROM ( SELECT s.id, p.latitude, p.longitude, (p.latitude^2-q.lat^2)+(p.longitude^2-q.lon^2) distance, q.ass FROM source s JOIN position p ON p.source_id = s.id JOIN map m ON m.id = s.map_id CROSS JOIN ( SELECT cd.lat lat, cd.lon lon, e.xass ass FROM clump c JOIN clumpdetails cd ON c.id = cd.clump_id JOIN ellipse e ON c.id = e.clump_id JOIN band b ON b.id = e.band_id WHERE b.resolution = :band AND c.id = :clump ) AS q WHERE m.name like 'MIPSGAL-GAL' )as r WHERE r.distance < r.ass";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("band", bandResolution);
        query.setParameter("clump", clumpid);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Source> sources = new ArrayList<>();
        for (Object[] o : rows) {
            Source source = new Source();
            source.setId((String) o[0]);
            source.setDistance((double) o[3]);
            Position p = new Position((double) o[1], (double) o[2], source);
            source.setPosition(p);
            sources.add(source);
        }
        return sources;
    }

    /* REQ 11 */
    public List<Source> getYoungStars(int id) throws Exception {
        String sql = "SELECT *\n" +
                "FROM source s\n" +
                "WHERE s.sourcetolowerresolution_id IN\n" +
                "(\n" +
                "  SELECT DISTINCT sf_z.source_id\n" +
                "  FROM source_flow sf_z\n" +
                "   JOIN(\n" +
                "    SELECT sf1.source_id, f1.value flux_4d5\n" +
                "    FROM source_flow sf1\n" +
                "    JOIN flow f1 ON f1.id = sf1.flows_id \n" +
                "    JOIN band b1 ON b1.id = f1.band_id AND b1.resolution = 4.5\n" +
                "  ) AS q1 ON sf_z.source_id = q1.source_id\n" +
                "  JOIN(\n" +
                "    SELECT sf1.source_id, f1.value flux_3d6\n" +
                "    FROM source_flow sf1\n" +
                "    JOIN flow f1 ON f1.id = sf1.flows_id \n" +
                "    JOIN band b1 ON b1.id = f1.band_id AND b1.resolution = 3.6\n" +
                "    WHERE f1.value > 0\n" +
                "  ) AS q2 ON sf_z.source_id = q2.source_id\n" +
                "  JOIN(\n" +
                "    SELECT sf1.source_id, f1.value flux_5d8\n" +
                "    FROM source_flow sf1\n" +
                "    JOIN flow f1 ON f1.id = sf1.flows_id \n" +
                "    JOIN band b1 ON b1.id = f1.band_id AND b1.resolution = 5.8\n" +
                "  ) AS q3 ON sf_z.source_id = q3.source_id\n" +
                "  WHERE flux_4d5 - flux_5d8 > 0.7\n" +
                "  AND flux_3d6 - flux_4d5 > 0.7\n" +
                "  AND flux_3d6 - flux_4d5 > 1.4*(flux_4d5 - flux_5d8 -0.7) + 0.15\n" +
                ")\n" +
                "AND s.id IN\n" +
                "(\n" +
                "  SELECT  r.id\n" +
                "  FROM\n" +
                "  (\n" +
                "    SELECT s.id, p.latitude, p.longitude, (p.latitude^2-q.lat^2)+(p.longitude^2-q.lon^2) distance, q.ass\n" +
                "    FROM source s\n" +
                "    JOIN position p ON p.source_id = s.id\n" +
                "    JOIN map m ON m.id = s.map_id\n" +
                "    CROSS JOIN \n" +
                "    (\n" +
                "      SELECT DISTINCT cd.lat lat, cd.lon lon, e.xass ass\n" +
                "      FROM clump c\n" +
                "      JOIN clumpdetails cd ON c.id = cd.clump_id\n" +
                "      JOIN ellipse e ON c.id = e.clump_id\n" +
                "      JOIN band b ON b.id = e.band_id\n" +
                "      AND c.id = :c_id\n" +
                "    ) AS q\n" +
                "    WHERE m.name like 'MIPSGAL-GAL'\n" +
                "  )as r\n" +
                "  WHERE r.distance < r.ass\n" +
                ")";
        Session s = super.openSession();
        Query query = s.createNativeQuery(sql);
        query.setParameter("c_id", id);
        List<Object[]> rows = query.getResultList();
        closeSession();
        if (rows.size() < 1)
            throw new Exception();
        List<Source> sources = new ArrayList<>();
        for (Object[] o : rows) {
            Source source = new Source();
            source.setId((String) o[0]);
            sources.add(source);
        }
        return sources;
    }
}
