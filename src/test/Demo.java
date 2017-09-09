/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: Demo
 * Last update: 9-set-2017 11.42.15
 * 
 */

package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Agency;
import main.org.bdc.model.galaxy.Band;
import main.org.bdc.model.galaxy.Instrument;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.model.galaxy.dao.SatelliteDao;
import main.org.bdc.model.people.UserType;
import main.org.bdc.model.people.User_Regegistered;
import main.org.bdc.service.parser.CSVFactory;

/**
 * The Class Demo.
 */
public class Demo {

    // /**
    // * The main method.
    // *
    // * @param args the arguments
    // */
    // public static void main(String[] args) {
    //
    // }

    /**
     * Creates the admin.
     */
    public void demoAdmin() {
        User_Regegistered admin = new User_Regegistered();
        admin.setFirstName("amministratore");
        admin.setLastName("amministratore");
        admin.setEmail("admin@email");
        admin.setUserId("amministratore");
        admin.setPassword("amministratore");
        admin.setUserType(UserType.ADMIN);
        DaoFactory.getInstance().getUserDao().insert(admin);
    }

    /**
     * Insert satelliti.
     */
    public void demoSatelliti() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2009, 07 - 1, 10);

        Satellite herschel = new Satellite();
        herschel.setName("Herschel");
        herschel.setAgenzia(new Agency("esa"));
        herschel.setStartDate(2009, 07, 10);
        herschel.setEndDate(2013, 06, 17);

        Instrument pacs = new Instrument("PACS", herschel);
        pacs.addBandaOperativa(new Band(70., 5.2, pacs));
        pacs.addBandaOperativa(new Band(160., 12., pacs));

        Instrument spire = new Instrument("SPIRE", herschel);
        spire.addBandaOperativa(new Band(250., 18., spire));
        spire.addBandaOperativa(new Band(350., 24., spire));
        spire.addBandaOperativa(new Band(500., 35., spire));

        Satellite spitzer = new Satellite();
        spitzer.setName("Spitzer");
        spitzer.setAgenzia(new Agency("NASA"));
        spitzer.setStartDate(2003, 12, 18);
        spitzer.setEndDate(2009, 05, 15);

        Instrument irac = new Instrument("IRAC", spitzer);
        irac.addBandaOperativa(new Band(3.6, 1.7, irac));
        irac.addBandaOperativa(new Band(4.5, 1.8, irac));
        irac.addBandaOperativa(new Band(5.8, 1.9, irac));
        irac.addBandaOperativa(new Band(8.0, 2.0, irac));

        Instrument mips = new Instrument("MIPS", spitzer);
        mips.addBandaOperativa(new Band(24.0, 6.0, mips));

        herschel.addStrumento(pacs);
        herschel.addStrumento(spire);
        spitzer.addStrumento(irac);
        spitzer.addStrumento(mips);

        SatelliteDao satelliteDao = DaoFactory.getInstance().getSatelliteDao();
        satelliteDao.insert(herschel);
        satelliteDao.insert(spitzer);

    }

    /**
     * Prova istanze.
     */
    public void provaIstanze() {
        try {
            Class<?> classe = Class.forName("main.org.bdc.model.galaxy.Posizione");

            Class<?>[] parameterTypes = {
                    double.class, double.class
            };

            Object[] parametersValue = {
                    52.2, 589
            };

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

    public void start() throws InterruptedException {
        Thread t = new Thread(new Runnable() {

            // });
            // Thread demo = new Thread(new Runnable() {

            @Override
            public void run() {
                Demo launcher = new Demo();
                launcher.demoSatelliti();
                launcher.provaIstanze();
                launcher.demoAdmin();
                try {
                    CSVFactory.translateFile1("/home/urania/Scrivania/csv/higal.csv");
                    CSVFactory.translateFile2("/home/urania/Scrivania/csv/higal_additionalinfo.csv");
                    // CSVFactory.translateFile3("/home/urania/Scrivania/csv/r08.csv");
                    // CSVFactory.translateFile4("/home/urania/Scrivania/csv/mips.csv");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.join();
    }

}
