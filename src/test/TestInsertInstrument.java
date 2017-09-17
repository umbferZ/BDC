/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test
 * Type: TestInsertInstrument
 * Last update: 14-set-2017 18.56.05
 * 
 */

package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.org.bdc.controls.C_UC_InsertNewInstrument;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.model.instruments.Instrument;
import main.org.bdc.service.dal.exception.SaveDalException;

/**
 * Created by Sasha on 13/09/17.
 */
@SuppressWarnings("unchecked")
@RunWith(value = Parameterized.class)
public class TestInsertInstrument {

    private Instrument instrument;

    @Parameterized.Parameters
    public static Collection<Instrument> data() {
        Instrument instrument1 = new Instrument();
        instrument1.setName("InstrumentTest");
        instrument1.addBandaOperativa(new Band(1000, 3, instrument1));
        instrument1.addBandaOperativa(new Band(2000, 4.5, instrument1));
        instrument1.setMap(new Map("MIPSGAL"));
        instrument1.setSatellite(new Satellite("Herschel"));

        Instrument instrument2 = new Instrument();
        instrument2.addBandaOperativa(new Band(1000, 3.8, instrument2));
        instrument2.addBandaOperativa(new Band(1000, 6.5, instrument2));
        instrument2.setMap(new Map("Glimpse"));
        return Arrays.asList(instrument1, instrument2);
    }

    public TestInsertInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Test
    public void test() {
        Instrument result = null;
        try {
            result = C_UC_InsertNewInstrument.getInstance().inserisciStrumento(instrument);
        } catch (SaveDalException e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull(result);

    }
}
