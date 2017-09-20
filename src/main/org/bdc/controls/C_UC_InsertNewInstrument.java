/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_InsertNewInstrument
 * Last update: 14-set-2017 18.32.22
 * 
 */

package main.org.bdc.controls;

import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.model.instruments.Instrument;
import main.org.bdc.service.dal.exception.SaveDalException;

public class C_UC_InsertNewInstrument {

    private static C_UC_InsertNewInstrument instance = null;

    public synchronized static C_UC_InsertNewInstrument getInstance() {
        if (instance == null)
            instance = new C_UC_InsertNewInstrument();
        return instance;
    }

    public List<Instrument> getAllInstrument() {
        return DaoFactory.getInstance().getInstrumentDao().getAll();
    }

    public Instrument inserisciStrumento(Instrument instrument) throws SaveDalException {
        return DaoFactory.getInstance().getInstrumentDao().save(instrument);

    }

    public Band insertBand(Band band, Instrument instrument) throws SaveDalException {

        if (instrument != null && band != null) {
            band.setInstrument(instrument);
            return DaoFactory.getInstance().getBandDao().save(band);
        }
        throw new SaveDalException("Impossible to save");
    }
}
