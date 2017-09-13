/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: Demo
 * Last update: 13-set-2017 0.20.28
 * 
 */

package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Agency;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.model.galaxy.dao.SatelliteDao;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.model.instruments.Instrument;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.model.people.UserType;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
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
        UserRegistered admin = new UserRegistered();
        admin.setFirstName("amministratore");
        admin.setLastName("amministratore");
        admin.setEmail("admin@email");
        admin.setUserId("amministratore");
        admin.setPassword("amministratore");
        admin.setUserType(UserType.ADMIN);
        try {
            DaoFactory.getInstance().getUserDao().saveOrUpdate(admin);
        } catch (SaveOrUpdateDalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Insert satelliti.
     */
    public void demoSatelliti() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2009, 07 - 1, 10);
        Map higal = new Map("Higal"), mips_gal = new Map("MIPS-GAL"), glimpse = new Map("Glimpse");

        Satellite herschel = new Satellite();
        herschel.setName("Herschel");
        herschel.setAgenzia(new Agency("esa"));
        herschel.setStartDate(2009, 07, 10);
        herschel.setEndDate(2013, 06, 17);

        Instrument pacs = new Instrument("PACS", herschel);
        pacs.addBandaOperativa(new Band(70., 5.2, pacs));
        pacs.addBandaOperativa(new Band(160., 12., pacs));
        pacs.setMap(higal);

        Instrument spire = new Instrument("SPIRE", herschel);
        spire.addBandaOperativa(new Band(250., 18., spire));
        spire.addBandaOperativa(new Band(350., 24., spire));
        spire.addBandaOperativa(new Band(500., 35., spire));
        spire.setMap(higal);

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
        irac.setMap(glimpse);

        Instrument mips = new Instrument("MIPS", spitzer);
        mips.addBandaOperativa(new Band(24.0, 6.0, mips));
        mips.setMap(mips_gal);

        herschel.addStrumento(pacs);
        herschel.addStrumento(spire);
        spitzer.addStrumento(irac);
        spitzer.addStrumento(mips);

        SatelliteDao satelliteDao = DaoFactory.getInstance().getSatelliteDao();
        try {
            satelliteDao.saveOrUpdate(herschel);
            satelliteDao.saveOrUpdate(spitzer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Prova istanze.
     */
    public void provaIstanze() {
        try {
            Class<?> classe = Class.forName("main.org.bdc.model.galaxy.Position");

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
                    CSVFactory.translateFile3("/home/urania/Scrivania/csv/r08.csv");
                    CSVFactory.translateFile4("/home/urania/Scrivania/csv/mips.csv");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        t.start();
        t.join();

        // try {
        //
        // DaoFactory dao = DaoFactory.getInstance();
        // Map higal = dao.getMapDao().getMapByName("Higal");
        // System.out.println(String.format("%s %s n=%s", higal.getId(),
        // higal.getName(), higal.getInstruments().size()));
        // Clump clump = new Clump();
        // clump.setId(666);
        // clump.setMap(higal);
        // higal.addClump(clump);
        // dao.getClumpDao().saveOrUpdate(clump);
        // } catch (Exception e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
    }

}
