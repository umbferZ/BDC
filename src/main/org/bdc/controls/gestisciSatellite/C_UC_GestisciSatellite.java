/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.controls.gestisciSatellite
 * Type: C_UC_GestisciSatellite
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package main.org.bdc.controls.gestisciSatellite;

import java.util.Calendar;
import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.entity.satelliti.Banda;
import main.org.bdc.model.entity.satelliti.Satellite;
import main.org.bdc.model.entity.satelliti.Strumento;

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
        satellite.setAgenzie(bean.getAgenziaSatellite());
        satellite.setNome(bean.getNomeSatellite());
        satellite.setInizio(startDate);
        satellite.setFine(endDate);
        DaoFactory.getInstance().getSatelliteDao().insert(satellite);
        // TODO throw new Exception();
    }

    public void inserisciStrumento(BeanInserisciStrumento bs, List<BeanInserisciBanda> bb) {

        Strumento strumento = new Strumento(bs.getNomeStrumento());
        for (BeanInserisciBanda b : bb)
            strumento.addBandaOperativa(new Banda(b.getRisoluzione(), b.getLunghezzaOnda()));
        DaoFactory.getInstance().getStrumentoDao().insert(strumento);

    }
}
