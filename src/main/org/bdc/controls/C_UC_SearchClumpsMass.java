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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.dao.ClumpDao;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_SearchClumpsMass {

    private static C_UC_SearchClumpsMass instance = null;

    public synchronized static C_UC_SearchClumpsMass getInstance() {
        if (instance == null)
            instance = new C_UC_SearchClumpsMass();
        return instance;
    }

    public String[] searchClumpsMass() throws Exception {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        List<Clump> list = clumpDao.getClumpMass();
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = String.format("clump %s - mass: %.2f", list.get(i).getId(), list.get(i).getMassa());
        return result;

    }

    public void showClumpsAvgMass() {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        try {
            System.out.println(String.format("AVG mass = %.2f", clumpDao.getAvgMassa()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showClumpsDevMass() {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();

    }

    public void showClumpsMidDevMass() {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();

    }

    public void showClumpsMidMass() {
        List<Clump> clumps = DaoFactory.getInstance().getClumpDao().getAll();
        ArrayList<Double> massSort = new ArrayList<>();
        for (Clump c : clumps) {
            // massSort;
        }
        Collections.sort(massSort);
        double mediana = massSort.size() % 2 == 0 ? (massSort.get(massSort.size() / 2) + massSort.get(massSort.size() / 2 - 1)) / 2 : (double) massSort.get(massSort.size() / 2);
        System.out.println(String.format("Mediana: %.2f", mediana));
    }

}
