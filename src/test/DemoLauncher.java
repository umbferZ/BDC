/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: DemoLauncher
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import org.bdc.controls.gestisciSatellite.C_UC_GestisciSatellite;
import org.bdc.model.DaoFactory;
import org.bdc.model.entity.satelliti.Banda;
import org.bdc.model.entity.satelliti.Satellite;
import org.bdc.model.entity.satelliti.Strumento;
import org.bdc.service.parser.CSVFactory;

public class DemoLauncher {

    public static void main(String[] args) {
        DemoLauncher launcher = new DemoLauncher();
        // launcher.provaController();
        // launcher.provaIstanze();
        // launcher.provaDao();
        try {
            launcher.provaQueueProducerConsumer(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void provaController() {
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
    }

    public void provaDao() {

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

    public void provaIstanze() {
        try {
            Class<?> classe = Class.forName("org.bdc.model.entity.Posizione");

            Class<?>[] parameterTypes = { double.class, double.class };

            Object[] parametersValue = { 52.2, 589 };

            Constructor<?> constructor = classe.getConstructor(parameterTypes);

            constructor.newInstance(parametersValue);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void provaQueueProducerConsumer(int file) throws Exception {
        switch (file) {
            case 1:
                CSVFactory.translateFile1("/home/urania/Scrivania/csv/higal.csv");
                break;
            case 2:
                CSVFactory.translateFile2("/home/urania/Scrivania/csv/higal_additionalinfo.csv");
                break;
            case 3:
                CSVFactory.translateFile3("/home/urania/Scrivania/csv/r08.csv");
                break;
            case 4:
                CSVFactory.translateFile4("/home/urania/Scrivania/csv/mips.csv");
                break;
            default:
                throw new Exception();
        }
    }

}
