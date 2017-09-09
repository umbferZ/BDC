/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.controls.gestisciSatellite
 * Type: C_UC_GestisciSatellite
 * Last update: 8-set-2017 16.48.59
 * 
 */

package main.org.bdc.controls.gestisciSatellite;

import java.util.Calendar;
import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Agency;
import main.org.bdc.model.galaxy.Band;
import main.org.bdc.model.galaxy.Instrument;
import main.org.bdc.model.galaxy.Satellite;

public class C_UC_GestisciSatellite {

    public void associaStrumentoSatellite(BeanAssociaStrumentoSatellite bean) {

    }

    public void importaDati(BeanImportaDati bean) {

    }

    public void inserisciSatellite(BeanInserisciSatellite bean) {

        Calendar startDate = Calendar.getInstance();
        startDate.set(bean.getStartYear(), bean.getStartMonth() - 1, bean.getStartDay());
        Calendar endDate = null;
        if (bean.getEndDay() > 0 && bean.getEndMonth() + 1 > 0 && bean.getEndYear() > 0) {
            endDate = Calendar.getInstance();
            endDate.set(bean.getEndYear(), bean.getEndMonth() - 1, bean.getEndDay());
        }
        Satellite satellite = new Satellite();
        satellite.setAgenzia(new Agency(bean.getAgenziaSatellite()));
        satellite.setName(bean.getNomeSatellite());
        satellite.setStartDate(startDate);
        satellite.setEndDate(endDate);
        DaoFactory.getInstance().getSatelliteDao().insert(satellite);
        // TODO throw new Exception();
    }

    public void inserisciStrumento(BeanInserisciStrumento bs, List<BeanInserisciBanda> bb) {

        Instrument instrument = new Instrument(bs.getNomeStrumento());
        for (BeanInserisciBanda b : bb)
            instrument.addBandaOperativa(new Band(b.getRisoluzione(), b.getLunghezzaOnda()));
        DaoFactory.getInstance().getStrumentoDao().insert(instrument);

    }
}
