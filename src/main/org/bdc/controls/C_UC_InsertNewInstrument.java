/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_InsertNewInstrument
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.controls;

import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.instruments.Band;
import main.org.bdc.model.instruments.Instrument;
import main.org.bdc.service.dal.exception.SaveDalException;

/**
 * The Class C_UC_InsertNewInstrument.
 */
public class C_UC_InsertNewInstrument {

    private static C_UC_InsertNewInstrument instance = null;

    /**
     * Gets the single instance of C_UC_InsertNewInstrument.
     *
     * @return single instance of C_UC_InsertNewInstrument
     */
    public synchronized static C_UC_InsertNewInstrument getInstance() {
        if (instance == null)
            instance = new C_UC_InsertNewInstrument();
        return instance;
    }

    /**
     * Gets the all instrument.
     *
     * @return the all instrument
     */
    public List<Instrument> getAllInstrument() {
        return DaoFactory.getInstance().getInstrumentDao().getAll();
    }

    /**
     * Inserisci strumento.
     *
     * @param instrument the instrument
     * @return the instrument
     * @throws SaveDalException the save dal exception
     */
    public Instrument inserisciStrumento(Instrument instrument) throws SaveDalException {
        return DaoFactory.getInstance().getInstrumentDao().save(instrument);

    }

    /**
     * Insert band.
     *
     * @param band the band
     * @param instrument the instrument
     * @return the band
     * @throws SaveDalException the save dal exception
     */
    public Band insertBand(Band band, Instrument instrument) throws SaveDalException {

        if (instrument != null && band != null) {
            band.setInstrument(instrument);
            return DaoFactory.getInstance().getBandDao().save(band);
        }
        throw new SaveDalException("Impossible to save");
    }
}
