/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: DemoLauncher
 * Last update: 10-mar-2017 15.47.04
 * 
 */

package test;

import java.util.Calendar;

import org.bdc.model.DaoFactory;
import org.bdc.model.entity.satelliti.Banda;
import org.bdc.model.entity.satelliti.Satellite;
import org.bdc.model.entity.satelliti.Strumento;

public class DemoLauncher {

    public static void main(String[] args) {

        // BeanInserisciSatellite bi = new BeanInserisciSatellite();
        // bi.setAgenziaSatellite("ESA");
        // bi.setNomeSatellite("Hersel");
        // bi.setStartYear(2009);
        // bi.setStartMonth(07);
        // bi.setStartDay(10);
        // bi.setEndYear(2013);
        // bi.setEndMonth(06);
        // bi.setEndDay(17);
        //
        // C_UC_GestisciSatellite controller = new C_UC_GestisciSatellite();
        // controller.inserisciSatellite(bi);

        Satellite satellite = new Satellite("ESA", "Hersel", Calendar.getInstance(), Calendar.getInstance());
        
        Strumento strumento = new Strumento("PACS", satellite);
        
        Banda b1 = new Banda(0.58, 52.0);
        Banda b2 = new Banda(0.47, 52.);
        
        strumento.addBandaOperativa(b1);
        strumento.addBandaOperativa(b2);
        
        b1.setStrumento(strumento);
        b2.setStrumento(strumento);
        
        satellite.addStrumento(strumento);
        
        DaoFactory.getInstance().getSatelliteDao().insert(satellite);


    }

}
