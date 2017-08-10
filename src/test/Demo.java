/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: test
 * Type: Demo
 * Last update: 10-ago-2017 17.18.49
 * 
 */

package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import main.org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import main.org.bdc.controls.gestisciSatellite.C_UC_GestisciSatellite;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.entity.satelliti.Banda;
import main.org.bdc.model.entity.satelliti.Satellite;
import main.org.bdc.model.entity.satelliti.Strumento;
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
    public void createAdmin() {
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
     * Prova controller.
     */
    public void provaController() {
        BeanInserisciSatellite bi = new BeanInserisciSatellite();
        bi.setAgenziaSatellite("ESA");
        bi.setNomeSatellite("Hersel");
        bi.setStartDate(2009, 07, 10);
        bi.setEndDate(2013, 06, 17);
        C_UC_GestisciSatellite controller = new C_UC_GestisciSatellite();
        controller.inserisciSatellite(bi);
    }

    /**
     * Prova dao.
     */
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

    /**
     * Prova istanze.
     */
    public void provaIstanze() {
        try {
            Class<?> classe = Class.forName("main.org.bdc.model.entity.Posizione");

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

    /**
     * Prova queue producer consumer.
     *
     * @param file the file
     * @throws Exception the exception
     */
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

    public void start() throws InterruptedException {
        Thread t = new Thread(new Runnable() {

            // });
            // Thread demo = new Thread(new Runnable() {

            @Override
            public void run() {
                Demo launcher = new Demo();
                launcher.provaController();
                launcher.provaIstanze();
                launcher.provaDao();
                launcher.createAdmin();
                for (int i = 1; i <= 4; i++)
                    try {
                        launcher.provaQueueProducerConsumer(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        });
        t.start();
        t.join();
    }

}
