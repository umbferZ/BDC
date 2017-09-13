package main.org.bdc.controls;

import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.dao.ClumpDao;

import java.util.List;

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

    public void searchClumpsMass(){
        ClumpDao clumpDao = new ClumpDao();
        try {
            List<Clump> list = clumpDao.getClumpMass();
            int i = 0;
            for (Clump c : list)
                System.out.println(String.format("%d , c_id = %d, massa = %.10f flow= %.2f, temp = %.2f", i++, c.getId(), c.getMassa(), c.getFlows().get(3).getValue(), c.getClumpDetails().getTemperatura()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showClumpsAvgMass(){
        ClumpDao clumpDao = new ClumpDao();
        try {
            System.out.println(String.format("AVG mass = %.2f", clumpDao.getAvgMassa()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
