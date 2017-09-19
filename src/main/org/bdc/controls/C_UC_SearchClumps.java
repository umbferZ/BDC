/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchClumps
 * Last update: 15-set-2017 15.43.10
 * 
 */

package main.org.bdc.controls;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Flow;
import main.org.bdc.model.galaxy.dao.ClumpDao;

import java.util.List;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_SearchClumps {

    private static C_UC_SearchClumps instance = null;

    public synchronized static C_UC_SearchClumps getInstance() {
        if (instance == null)
            instance = new C_UC_SearchClumps();
        return instance;
    }

    public String[] searchClumps(int id) throws Exception {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        List<Clump> list = clumpDao.getClumpByID(id);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Clump c = list.get(i);
            for (Flow f : c.getFlows())
                result[i] = String.format("clump %d - flux: %.4f - band resolution: %.2f - lat: %.4f - lon: %.4f",
                        c.getId(), f.getValue(),
                        f.getBanda().getResolution(),
                        c.getClumpDetails().getLat(), c.getClumpDetails().getLon());
        }
        return result;
    }

}
