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

    // public String[] getFlows(int clumpid) throws Exception {
    // List<Flow> flows =
    // DaoFactory.getInstance().getFlowDao().getFlows(clumpid);
    // String[] result = new String[flows.size()];
    // // for(int i = 0; i<flows.size();i++)
    // // result[i] = String.format("clump_id %d, flows", args) //todo
    // }

    public Clump searchClumps(int id) throws Exception {
        Clump c = DaoFactory.getInstance().getClumpDao().getById(id);
        if (c == null)
            throw new Exception("nessun clump");
        return c;
    }

}
