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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

        // Satellite satellite = new Satellite("ESA", "Hersel",
        // Calendar.getInstance(), Calendar.getInstance());
        //
        // Strumento strumento = new Strumento("PACS", satellite);
        //
        // Banda b1 = new Banda(0.58, 52.0);
        // Banda b2 = new Banda(0.47, 52.);
        //
        // strumento.addBandaOperativa(b1);
        // strumento.addBandaOperativa(b2);
        //
        // b1.setStrumento(strumento);
        // b2.setStrumento(strumento);
        //
        // satellite.addStrumento(strumento);
        //
        // DaoFactory.getInstance().getSatelliteDao().insert(satellite);

        // FIXME get className

        try {
            Class<?> classe = Class.forName("org.bdc.model.entity.Posizione");

            Class<?>[] parameterTypes = { double.class, double.class };

            Object[] parametersValue = { 52.2, 589 };

            Constructor<?> constructor = classe.getConstructor(parameterTypes);

            Object date = constructor.newInstance(parametersValue);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
