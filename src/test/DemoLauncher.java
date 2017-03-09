/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: DemoLauncher
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package test;

import org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import org.bdc.controls.gestisciSatellite.C_UC_GestisciSatellite;

public class DemoLauncher {
    public static void main(String[] args) {

        BeanInserisciSatellite bi = new BeanInserisciSatellite();
        bi.setAgenziaSatellite("ESA");
        bi.setNomeSatellite("Hersel");
        bi.setStartYear(2009);
        bi.setStartMonth(07);
        bi.setStartDay(10);
        bi.setEndYear(2013);
        bi.setEndMonth(06);
        bi.setEndDay(17);

        C_UC_GestisciSatellite controller = new C_UC_GestisciSatellite();
        controller.inserisciSatellite(bi);

        // DaoFactory dao = DaoFactory.getInstance();
        // Satellite hershel = new Satellite("Hershel", Agenzia.ESA,
        // Calendar.getInstance(), Calendar.getInstance());
        // Satellite spitzer = new Satellite("Spitzer", Agenzia.NASA,
        // Calendar.getInstance(), Calendar.getInstance());

        // dao.getSatelliteDao().insert(hershel);
        // dao.getSatelliteDao().insert(spitzer);

        // List<Satellite> satelliti = dao.getSatelliteDao().getAll();
        // for (Satellite s : satelliti) {
        // if (s.getNome() == "Hershel")
        // hershel = s;
        // else if (s.getNome() == "Spitzer")
        // spitzer = s;
        //
        // }

        // dao.getStrumentoDao().insert(new Strumento("PACS", hershel));
        // dao.getStrumentoDao().insert(new Strumento("SPIRE", hershel));
        // dao.getStrumentoDao().insert(new Strumento("IRAC", spitzer));
        // dao.getStrumentoDao().insert(new Strumento("MIPS", spitzer));
        // dao.getStrumentoDao().insert(new Strumento("PACS", spitzer));
    }

}
