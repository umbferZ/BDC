package main.org.bdc.controls;

import main.org.bdc.controls.gestisciSatellite.BeanInserisciBanda;
import main.org.bdc.controls.gestisciSatellite.BeanInserisciStrumento;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.model.instruments.Instrument;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;

import java.util.List;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_InsertNewInstrument {

    private static C_UC_InsertNewInstrument instance = null;

    public synchronized static C_UC_InsertNewInstrument getInstance() {
        if (instance == null)
            instance = new C_UC_InsertNewInstrument();
        return instance;
    }

    public void inserisciStrumento(BeanInserisciStrumento bs, List<BeanInserisciBanda> bb) {

        Instrument instrument = new Instrument(bs.getNomeStrumento());
        for (BeanInserisciBanda b : bb)
            instrument.addBandaOperativa(new Band(b.getRisoluzione(), b.getLunghezzaOnda()));
        try {
            DaoFactory.getInstance().getInstrumentDao().saveOrUpdate(instrument);
        } catch (SaveOrUpdateDalException e) {
            e.printStackTrace();
        }

    }
}
