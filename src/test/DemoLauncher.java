/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: DemoLauncher
 * Last update: 8-mar-2017 14.11.14
 * 
 */
package test;

import java.util.Calendar;

import org.bdc.model.DaoFactory;
import org.bdc.model.entity.Agenzia;
import org.bdc.model.entity.Satellite;
import org.bdc.model.entity.Strumento;

public class DemoLauncher {
    public static void main(String[] args) {

        DaoFactory dao = DaoFactory.getInstance();
        Satellite hershel = new Satellite("Hershel", Agenzia.ESA, Calendar.getInstance(), Calendar.getInstance());
        Satellite spitzer = new Satellite("Spitzer", Agenzia.NASA, Calendar.getInstance(), Calendar.getInstance());

        dao.getSatelliteDao().insert(hershel);
        dao.getSatelliteDao().insert(spitzer);
        //
        // List<Satellite> satelliti = dao.getSatelliteDao().getAll();
        // for (Satellite s : satelliti) {
        // if (s.getNome() == "Hershel")
        // hershel = s;
        // else if (s.getNome() == "Spitzer")
        // spitzer = s;
        //
        // }

//        dao.getStrumentoDao().insert(new Strumento("PACS", hershel));
//        dao.getStrumentoDao().insert(new Strumento("SPIRE", hershel));
//        dao.getStrumentoDao().insert(new Strumento("IRAC", spitzer));
//        dao.getStrumentoDao().insert(new Strumento("MIPS", spitzer));

    }

}
