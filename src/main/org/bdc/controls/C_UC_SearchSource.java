/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchSource
 * Last update: 15-set-2017 13.21.29
 * 
 */

package main.org.bdc.controls;

import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Source;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_SearchSource {

    private static C_UC_SearchSource instance = null;

    public static C_UC_SearchSource getInstance() {
        if (instance == null)
            instance = new C_UC_SearchSource();
        return instance;
    }

    private C_UC_SearchSource() {}

    public String[] searchSourceInMipsGal(int id, double band) throws Exception {

        List<Source> list = DaoFactory.getInstance().getSourceDao().getSourceInClump(id, band);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Source s = list.get(i);
            result[i] = String.format("source_id %s, latitude %.2f, longitude %.2f, distance %.2f", s.getId(), s.getPosition().getLatitude(), s.getPosition().getLongitude(), s.getDistance());
        }
        return result;
    }

    public String[] searchSourceInRegion(boolean isClump, boolean isSquare, double latitude, double longitude, double distance, int limit) throws Exception {
        if (isClump && isSquare) {
            List<Clump> list = DaoFactory.getInstance().getClumpDao().getByPositionIntoSquare(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Clump s = list.get(i);
                result[i] = String.format("clump_id %s, latitude %.2f, longitude %.2f, distance %.2f", s.getId(), s.getClumpDetails().getLat(), s.getClumpDetails().getLon(), s.getDistance());
            }
            return result;
        } else if (isClump && !isSquare) {
            List<Clump> list = DaoFactory.getInstance().getClumpDao().getByPositionIntoRound(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Clump s = list.get(i);
                result[i] = String.format("clump_id %s, latitude %.2f, longitude %.2f, distance %.2f", s.getId(), s.getClumpDetails().getLat(), s.getClumpDetails().getLon(), s.getDistance());
            }
            return result;

        } else if (!isClump && isSquare) {
            List<Source> list = DaoFactory.getInstance().getSourceDao().getByPositionIntoSqure(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Source s = list.get(i);
                result[i] = String.format("source_id %s, latitude %.2f, longitude %.2f, distance %.2f", s.getId(), s.getPosition().getLatitude(), s.getPosition().getLongitude(), s.getDistance());
            }
            return result;
        } else {

            List<Source> list = DaoFactory.getInstance().getSourceDao().getByPositionIntoRound(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Source s = list.get(i);
                result[i] = String.format("source_id %s, latitude %.2f, longitude %.2f, distance %.2f", s.getId(), s.getPosition().getLatitude(), s.getPosition().getLongitude(), s.getDistance());
            }
            return result;
        }

    }

}
