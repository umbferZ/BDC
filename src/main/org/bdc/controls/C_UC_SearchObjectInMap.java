/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchObjectInMap
 * Last update: 15-set-2017 11.53.36
 * 
 */

package main.org.bdc.controls;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.model.galaxy.dao.SourceDao;

import java.util.List;

public class C_UC_SearchObjectInMap {

    private static C_UC_SearchObjectInMap instance = null;

    public synchronized static C_UC_SearchObjectInMap getInstance() {
        if (instance == null)
            instance = new C_UC_SearchObjectInMap();
        return instance;
    }

    /* MAIN DI PROVA */
    public static void main(String[] args) {
        try {
            String[] sources = C_UC_SearchObjectInMap.getInstance().searchForAllBands("Glimpse", 1);
            for (int i=0; i<sources.length; i++)
                System.out.println(String.format("%s", sources[i]));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* REQ 05 */
    public String[] searchByBand(String map_name, int limit, double band_res) throws Exception {
        SourceDao sourceDao = DaoFactory.getInstance().getSourceDao();
        List<Source> sources = sourceDao.getByMap(map_name, limit, band_res);
        String[] result = new String[sources.size()];
        for (int i = 0; i < sources.size(); i++)
            result[i] = String.format("Source ID %s", sources.get(i).getId());
        return result;
    }

    /* REQ 05 */
    public String[] searchForAllBands(String map_name, int limit) throws Exception {
        SourceDao sourceDao = DaoFactory.getInstance().getSourceDao();
        List<Source> sources = sourceDao.getByMap(map_name, limit);
        String[] result = new String[sources.size()];
        for (int i = 0; i < sources.size(); i++)
            result[i] = String.format("Source ID: %s - Band Resolution: %.2f - Flux Value: %.4f",
                    sources.get(i).getId(), sources.get(i).getFlows().get(i).getBanda().getResolution(),
                    sources.get(i).getFlows().get(i).getValue());
        return result;
    }

}
