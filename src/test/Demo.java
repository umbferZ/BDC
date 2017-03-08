/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: Demo
 * Last update: 8-mar-2017 9.36.51
 * 
 */
package test;

import java.util.Calendar;

import org.bdc.model.e.DaoFactory;
import org.bdc.model.entity.Agenzia;
import org.bdc.model.entity.Satellite;
import org.bdc.model.entity.Strumento;

public class Demo {
    public static void main(String[] args) {

        Satellite hershel = new Satellite("Hershel", Agenzia.ESA, Calendar.getInstance(), Calendar.getInstance());
        Satellite spitzer = new Satellite("Spitzer", Agenzia.NASA, Calendar.getInstance(), Calendar.getInstance());

        Strumento pacs = new Strumento("PACS", hershel);
        Strumento spire = new Strumento("SPIRE", hershel);
        Strumento irac = new Strumento("IRAC", spitzer);
        Strumento mips = new Strumento("MIPS", spitzer);

        DaoFactory dao = DaoFactory.getInstance();
        dao.getStrumentoDao().insert(pacs);
        dao.getStrumentoDao().insert(spire);
        dao.getStrumentoDao().insert(irac);
        dao.getStrumentoDao().insert(mips);

    }

}
