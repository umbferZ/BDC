/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchYoungStars
 * Last update: 20-set-2017 13.23.21
 * 
 */
package main.org.bdc.controls;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.model.galaxy.dao.ClumpDao;
import main.org.bdc.model.galaxy.dao.SourceDao;
import java.util.List;

/**
 * The Class C_UC_SearchYoungStars.
 */
public class C_UC_SearchYoungStars {

    private static C_UC_SearchYoungStars instance = null;

    /**
     * Gets the single instance of C_UC_SearchYoungStars.
     *
     * @return single instance of C_UC_SearchYoungStars
     */
    public synchronized static C_UC_SearchYoungStars getInstance() {
        if (instance == null)
            instance = new C_UC_SearchYoungStars();
        return instance;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    /* MAIN DI PROVA */
    public static void main(String[] args) {
        try {
            String[] clumps = C_UC_SearchYoungStars.getInstance().showClumps();
            for (int i=0; i<clumps.length; i++)
                System.out.println(String.format("%s", clumps[i]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Show clumps.
     *
     * @return the string[]
     * @throws Exception the exception
     */
    /* Show all Clumps in JFrameMain's List */
    public String[] showClumps() throws Exception {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        List<Clump> list = clumpDao.showClumps();
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = String.format("%s", list.get(i).getId());
        return result;
    }

    /**
     * Young stars.
     *
     * @param id the id
     * @return the string[]
     * @throws Exception the exception
     */
    /* REQ 11 */
    public String[] youngStars(int id) throws Exception {
        SourceDao sourceDao = DaoFactory.getInstance().getSourceDao();
        List<Source> sources = sourceDao.getYoungStars(id);
        String[] result = new String[sources.size()];
        for (int i = 0; i < sources.size(); i++)
            result[i] = String.format("%s", sources.get(i).getId());
        return result;
    }
}
