package main.org.bdc.controls;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.model.galaxy.dao.ClumpDao;
import main.org.bdc.model.galaxy.dao.SourceDao;

import java.util.List;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_SearchYoungStars {

    private static C_UC_SearchYoungStars instance = null;

    public synchronized static C_UC_SearchYoungStars getInstance() {
        if (instance == null)
            instance = new C_UC_SearchYoungStars();
        return instance;
    }

    public static void main(String[] args) {
        try {
            String[] clumps = C_UC_SearchYoungStars.getInstance().showClumps();
            for (int i=0; i<clumps.length; i++)
                System.out.println(String.format("%s", clumps[i]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] showClumps() throws Exception {
        ClumpDao clumpDao = DaoFactory.getInstance().getClumpDao();
        List<Clump> list = clumpDao.showClumps();
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = String.format("%s", list.get(i).getId());
        return result;
    }

    public String[] youngStars(int id) throws Exception {
        SourceDao sourceDao = DaoFactory.getInstance().getSourceDao();
        List<Source> sources = sourceDao.getYoungStars(id);
        String[] result = new String[sources.size()];
        for (int i = 0; i < sources.size(); i++)
            result[i] = String.format("%s", sources.get(i).getId());
        return result;
    }
}
