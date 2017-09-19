/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchClumpsMass
 * Last update: 15-set-2017 12.06.05
 * 
 */

package main.org.bdc.controls;

import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.dao.ClumpDao;

public class C_UC_ClumpsMasses {

    private static C_UC_ClumpsMasses instance = null;

    public synchronized static C_UC_ClumpsMasses getInstance() {
        if (instance == null)
            instance = new C_UC_ClumpsMasses();
        return instance;
    }

    public String[] showStats() throws Exception {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        double avg = clumpDao.getAvgMassa();
        String[] result = new String[4];
        result[0] = String.format("AVG: %.3f", avg);
        double stddev = clumpDao.getStdDevMassa();
        result[1] = String.format("STDDEV: %.3f", stddev);
        double mad = clumpDao.getMADMassa();
        result[2] = String.format("MAD: %.3f", mad);
        double med = clumpDao.getMedian();
        result[3] = String.format("MED: %.3f", med);
        return result;
    }

    public String[] searchClumpsMass() throws Exception {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        List<Clump> list = clumpDao.getClumpMass();
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = String.format("clump %s - mass: %.2f", list.get(i).getId(), list.get(i).getMassa());
        return result;

    }

    public String[] searchClumpsDensities() throws Exception {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        List<Clump> list = clumpDao.getClumpDensity();
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = String.format("clump %s - fraction: %.5f", list.get(i).getId(), list.get(i).getFraction());
        return result;

    }

}
