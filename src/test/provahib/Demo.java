/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test.provahib
 * Type: Demo
 * Last update: 13-set-2017 14.15.57
 * 
 */

package test.provahib;

import java.util.List;

import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;

public class Demo {

    public static void main(String[] args) {

        LavoratoreDAO lDao = new LavoratoreDAO();
        Azienda azienda = new Azienda();
        azienda.setName("Azienda 1");
        azienda.setQualcosa("Qualcosa 1");
        try {
            new AziendaDAO().saveOrUpdate(azienda);
        } catch (SaveOrUpdateDalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            Lavoratore lavoratore = new Lavoratore();
            lavoratore.setName(String.format("Lavoratore %d", i));
            lavoratore.setOther(String.format("Lavoratore Auotmatico %d", i));
            lavoratore.setAzienda(azienda);
            try {
                lDao.saveOrUpdate(lavoratore);
            } catch (SaveOrUpdateDalException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Azienda azienda2 = new Azienda();
        azienda2.setName("Azienda 2");
        azienda2.setQualcosa("Qualcosa 2");
        try {
            new AziendaDAO().saveOrUpdate(azienda2);
        } catch (SaveOrUpdateDalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Lavoratore> lavoratori = new LavoratoreDAO().getAll();
        for (Lavoratore l : lavoratori) {
            if (l.getId() % 2 == 0)
                continue;
            l.setAzienda(azienda2);
            l.setOther("Passato alla nuova azienda");
            try {
                new LavoratoreDAO().saveOrUpdate(l);
            } catch (SaveOrUpdateDalException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 50; i++) {
            Lavoratore lavoratore = new Lavoratore();
            lavoratore.setName(String.format("Lavoratore %d", i));
            lavoratore.setOther(String.format("Lavoratore dopo seriaizzazione %d", i));
            lavoratore.setAzienda(azienda2);
            try {
                new LavoratoreDAO().saveOrUpdate(lavoratore);
            } catch (SaveOrUpdateDalException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
