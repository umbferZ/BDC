package test;

import main.org.bdc.controls.C_UC_InsertNewInstrument;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.model.instruments.Instrument;
import main.org.bdc.model.people.UserRegistered;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Sasha on 13/09/17.
 */
@RunWith(value = Parameterized.class)
public class TestInsertInstrument {

    private Instrument instrument;

    public TestInsertInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Parameterized.Parameters
    public static Collection<Instrument> data() {

        //user admin
        Instrument instrument1 = new Instrument();
        instrument1.addBandaOperativa(new Band(350,3));
        instrument1.addBandaOperativa(new Band(250, 4.5));
        instrument1.setMap(new Map("MIPSGAL"));

        //user no admin
        Instrument instrument2 = new Instrument();
        instrument2.addBandaOperativa(new Band(70,3.8));
        instrument2.addBandaOperativa(new Band(500, 6.5));
        instrument2.setMap(new Map("Glimpse"));

        return Arrays.asList(
                instrument1,
                instrument2
        );
    }

    @Test
    public void test() {

        C_UC_InsertNewInstrument.getInstance().inserisciStrumento(this.instrument);

    }
}
