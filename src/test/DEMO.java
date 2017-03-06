package test;

import java.util.ArrayList;
import java.util.List;

import org.bdc.model.e.E1;
import org.bdc.model.e.E2;
import org.bdc.model.e.E3;
import org.bdc.model.e.FactoryDao;

public class DEMO {
    public static void main(String[] args) {

        FactoryDao dao = FactoryDao.getInstance();

        E3 francesco = new E3();
        francesco.setNome("Ottaviano");
        dao.getE3Dao().insert(francesco);
        E3 umby = new E3();
        umby.setNome("umby");
        dao.getE3Dao().insert(umby);

        List<E3> utenti = dao.getE3Dao().getAll();

        for (E3 e3 : utenti) {
            for (int i = 0; i < 4; i++) {
                E1 e1 = new E1();
                e1.setNome("e1_" + e3.getNome() + "_" + i);
                List<E2> list = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    E2 e2 = new E2();
                    e2.setNome("e2_" + e3.getNome() + "_" + i + "_" + j);
                    list.add(e2);
                }
                e1.setListE2(list);
                e3.setE1(e1);
            }
            dao.getE3Dao().insert(e3);
        }

        List<E2> list = dao.getE2Dao().getAll();
        for (E2 e2 : list) {
            System.out.println(e2.getId() + "\t" + e2.getNome());
        }
    }

}
