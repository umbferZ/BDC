/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchClumps
 * Last update: 14-set-2017 0.17.16
 * 
 */

package main.org.bdc.controls;

import main.org.bdc.model.galaxy.dao.ClumpDao;

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

    public void searchClumps() {
        ClumpDao clumpDao = new ClumpDao();
        clumpDao.getById();

    }

}
