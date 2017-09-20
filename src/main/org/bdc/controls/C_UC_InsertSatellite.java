/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_InsertSatellite
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.controls;

import java.util.Calendar;

import main.org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Agency;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.service.dal.exception.SaveDalException;

/**
 * The Class C_UC_InsertSatellite.
 */
public class C_UC_InsertSatellite {

    private static C_UC_InsertSatellite instance = null;

    /**
     * Gets the single instance of C_UC_InsertSatellite.
     *
     * @return single instance of C_UC_InsertSatellite
     */
    public synchronized static C_UC_InsertSatellite getInstance() {
        if (instance == null)
            instance = new C_UC_InsertSatellite();
        return instance;
    }

    /**
     * Inserisci satellite.
     *
     * @param bean the bean
     * @return the satellite
     * @throws SaveDalException the save dal exception
     */
    /* REQ 03.3 */
    public Satellite inserisciSatellite(BeanInserisciSatellite bean) throws SaveDalException {
        Calendar startDate = Calendar.getInstance();
        startDate.set(bean.getStartYear(), bean.getStartMonth() - 1, bean.getStartDay());
        Calendar endDate = null;
        if (bean.getEndDay() > 0 && bean.getEndMonth() + 1 > 0 && bean.getEndYear() > 0) {
            endDate = Calendar.getInstance();
            endDate.set(bean.getEndYear(), bean.getEndMonth() - 1, bean.getEndDay());
        }
        Satellite satellite = new Satellite();
        if (bean.getAgenziaSatellite().equals(""))
            throw new SaveDalException("Impossible to save!");
        satellite.setAgenzia(new Agency(bean.getAgenziaSatellite()));
        satellite.setName(bean.getNomeSatellite());
        satellite.setStartDate(startDate);
        satellite.setEndDate(endDate);
        return DaoFactory.getInstance().getSatelliteDao().save(satellite);
    }

}
