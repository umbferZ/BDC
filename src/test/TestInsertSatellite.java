package test;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.model.galaxy.dao.SatelliteDao;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
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

    private Satellite satellite;
    private String result;

    public TestInsertSatellite(String result, Satellite satellite) {
        this.satellite = satellite;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters(){

        Satellite satellite1 = new Satellite();
        Satellite satellite2 = new Satellite();
        Satellite satellite3 = new Satellite();



        return Arrays.asList(new Object[][]{
                {"ok",satellite1}, {"ok", satellite2}, {"error",satellite3}
        });

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = SaveOrUpdateDalException.class)
    public void insert(){
        //thrown.expect();
        SatelliteDao satelliteDao = DaoFactory.getInstance().getSatelliteDao();
        //Assert.assertNotNull(result, satelliteDao.saveOrUpdate(this.satellite));
    }
}
