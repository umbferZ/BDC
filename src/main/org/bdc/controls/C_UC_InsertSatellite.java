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

package main.org.bdc.controls;

import java.util.Calendar;

import main.org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Agency;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;

public class C_UC_InsertSatellite {

    private static C_UC_InsertSatellite instance = null;

    public synchronized static C_UC_InsertSatellite getInstance() {
        if (instance == null)
            instance = new C_UC_InsertSatellite();
        return instance;
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
        try {
            DaoFactory.getInstance().getSatelliteDao().saveOrUpdate(satellite);
        } catch (SaveOrUpdateDalException e) {
            e.printStackTrace();
        }
    }

}
