/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchSource
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.controls;

import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Source;

/**
 * The Class C_UC_SearchSource.
 */
public class C_UC_SearchSource {

    private static C_UC_SearchSource instance = null;

    /**
     * Gets the single instance of C_UC_SearchSource.
     *
     * @return single instance of C_UC_SearchSource
     */
    public static C_UC_SearchSource getInstance() {
        if (instance == null)
            instance = new C_UC_SearchSource();
        return instance;
    }

    /**
     * Instantiates a new c U C search source.
     */
    private C_UC_SearchSource() {}

    /**
     * Search source in mips gal.
     *
     * @param id the id
     * @param band the band
     * @return the string[]
     * @throws Exception the exception
     */
    /* REQ 09 */
    public String[] searchSourceInMipsGal(int id, double band) throws Exception {

        List<Source> list = DaoFactory.getInstance().getSourceDao().getSourceInClump(id, band);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Source s = list.get(i);
            result[i] = String.format("Source ID: %s - Lat: %.5f - Lon: %.5f - Distance %.3f",
                    s.getId(), s.getPosition().getLatitude(), s.getPosition().getLongitude(), s.getDistance());
        }
        return result;
    }

    /**
     * Search source in region.
     *
     * @param isClump the is clump
     * @param isSquare the is square
     * @param latitude the latitude
     * @param longitude the longitude
     * @param distance the distance
     * @param limit the limit
     * @return the string[]
     * @throws Exception the exception
     */
    /* REQ 08 */
    public String[] searchSourceInRegion(boolean isClump, boolean isSquare, double latitude, double longitude, double distance, int limit) throws Exception {
        if (isClump && isSquare) {
            List<Clump> list = DaoFactory.getInstance().getClumpDao().getByPositionIntoSquare(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Clump s = list.get(i);
                result[i] = String.format("Clump ID: %s - Lat: %.5f - Lon: %.5f - Distance %.3f", s.getId(), s.getClumpDetails().getLat(), s.getClumpDetails().getLon(), s.getDistance());
            }
            return result;
        } else if (isClump && !isSquare) {
            List<Clump> list = DaoFactory.getInstance().getClumpDao().getByPositionIntoRound(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Clump s = list.get(i);
                result[i] = String.format("Clump ID: %s - Lat: %.5f - Lon: %.5f - Distance %.3f", s.getId(), s.getClumpDetails().getLat(), s.getClumpDetails().getLon(), s.getDistance());
            }
            return result;

        } else if (!isClump && isSquare) {
            List<Source> list = DaoFactory.getInstance().getSourceDao().getByPositionIntoSqure(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Source s = list.get(i);
                result[i] = String.format("Source ID: %s - Lat: %.5f - Lon: %.5f - Distance %.3f", s.getId(), s.getPosition().getLatitude(), s.getPosition().getLongitude(), s.getDistance());
            }
            return result;
        } else {

            List<Source> list = DaoFactory.getInstance().getSourceDao().getByPositionIntoRound(latitude, longitude, distance, limit);
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Source s = list.get(i);
                result[i] = String.format("Source ID: %s - Lat: %.5f - Lon: %.5f - Distance %.3f", s.getId(), s.getPosition().getLatitude(), s.getPosition().getLongitude(), s.getDistance());
            }
            return result;
        }

    }

}
