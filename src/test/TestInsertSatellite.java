package test;

import main.org.bdc.controls.C_UC_InsertSatellite;
import main.org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Agency;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.model.galaxy.dao.SatelliteDao;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Sasha on 13/09/17.
 */

@RunWith(value = Parameterized.class)
public class TestInsertSatellite {

    private BeanInserisciSatellite satellite;

    public TestInsertSatellite(BeanInserisciSatellite satellite) {
        this.satellite = satellite;
    }

    @Parameterized.Parameters
    public static Collection<BeanInserisciSatellite> getTestParameters(){

        BeanInserisciSatellite satelliteAlreadyInDB = new BeanInserisciSatellite();
        satelliteAlreadyInDB.setNomeSatellite("Herschel");
        satelliteAlreadyInDB.setAgenziaSatellite("ESA");
        satelliteAlreadyInDB.setStartDate(12,12,2012);
        satelliteAlreadyInDB.setEndDate(13,7,2014);

        BeanInserisciSatellite satelliteNotInDB = new BeanInserisciSatellite();
        satelliteNotInDB.setNomeSatellite("Satellite Test");
        satelliteNotInDB.setAgenziaSatellite("ESA");
        satelliteNotInDB.setStartDate(12,12,2012);
        satelliteNotInDB.setEndDate(13,7,2014);

        BeanInserisciSatellite satelliteEmptyField = new BeanInserisciSatellite();
        satelliteEmptyField.setNomeSatellite("Satellite");
        satelliteEmptyField.setAgenziaSatellite("");
        satelliteEmptyField.setStartDate(2,7,2015);


        return Arrays.asList(
                satelliteAlreadyInDB,
                satelliteNotInDB
        );
    }

    @Test
    public void test() throws SaveOrUpdateDalException {
        C_UC_InsertSatellite.getInstance().inserisciSatellite(this.satellite);
        Assert.assertNotEquals("Already in DB", "Herschel", satellite.getNomeSatellite());
        Assert.assertNotEquals("Missing Fields", "", satellite.getAgenziaSatellite());

    }
}
