/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test
 * Type: TestInsertSatellite
 * Last update: 14-set-2017 18.06.20
 * 
 */

package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.org.bdc.controls.C_UC_InsertSatellite;
import main.org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.service.dal.exception.SaveDalException;

/**
 * Created by Sasha on 13/09/17.
 */

@RunWith(value = Parameterized.class)
public class TestInsertSatellite {

    private BeanInserisciSatellite satellite;

    @Parameterized.Parameters
    public static Collection<BeanInserisciSatellite> getTestParameters() {

        BeanInserisciSatellite satelliteAlreadyInDB = new BeanInserisciSatellite();
        satelliteAlreadyInDB.setNomeSatellite("Herschel");
        satelliteAlreadyInDB.setAgenziaSatellite("ESA");
        satelliteAlreadyInDB.setStartDate(12, 12, 2012);
        satelliteAlreadyInDB.setEndDate(13, 7, 2014);

        BeanInserisciSatellite satelliteNotInDB = new BeanInserisciSatellite();
        satelliteNotInDB.setNomeSatellite("Satellite Test2");
        satelliteNotInDB.setAgenziaSatellite("ESA");
        satelliteNotInDB.setStartDate(12, 12, 2012);
        satelliteNotInDB.setEndDate(13, 7, 2014);

        BeanInserisciSatellite satelliteEmptyField = new BeanInserisciSatellite();
        satelliteEmptyField.setNomeSatellite("Satellite");
        satelliteEmptyField.setAgenziaSatellite("");
        satelliteEmptyField.setStartDate(2, 7, 2015);

        return Arrays.asList(satelliteAlreadyInDB, satelliteNotInDB, satelliteEmptyField);
    }

    public TestInsertSatellite(BeanInserisciSatellite satellite) {
        this.satellite = satellite;
    }

    @Test
    public void test() {
        Satellite satellite = null;

        try {
            satellite = C_UC_InsertSatellite.getInstance().inserisciSatellite(this.satellite);
        } catch (SaveDalException e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull(satellite);
        /*Assert.assertNotEquals("Already in DB", "Herschel", this.satellite.getNomeSatellite());
        Assert.assertNotEquals("Missing Fields", "", this.satellite.getAgenziaSatellite());*/

    }
}
