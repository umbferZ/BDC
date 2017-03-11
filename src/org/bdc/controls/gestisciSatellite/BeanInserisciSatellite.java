/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.controls.gestisciSatellite
 * Type: BeanInserisciSatellite
 * Last update: 11-mar-2017 19.20.50
 * 
 */

package org.bdc.controls.gestisciSatellite;

public class BeanInserisciSatellite {

    private String nomeSatellite, agenziaSatellite;

    private int startDay, startMonth, startYear, endDay, endMonth, endYear;

    public String getAgenziaSatellite() {

        return agenziaSatellite;
    }

    public int getEndDay() {

        return endDay;
    }

    public int getEndMonth() {

        return endMonth;
    }

    public int getEndYear() {

        return endYear;
    }

    public String getNomeSatellite() {

        return nomeSatellite;
    }

    public int getStartDay() {

        return startDay;
    }

    public int getStartMonth() {

        return startMonth;
    }

    public int getStartYear() {

        return startYear;
    }

    public void setAgenziaSatellite(String agenziaSatellite) {

        this.agenziaSatellite = agenziaSatellite;
    }

    public void setEndDay(int endDay) {

        this.endDay = endDay;
    }

    public void setEndMonth(int endMonth) {

        this.endMonth = endMonth;
    }

    public void setEndYear(int endYear) {

        this.endYear = endYear;
    }

    public void setNomeSatellite(String nomeSatellite) {

        this.nomeSatellite = nomeSatellite;
    }

    public void setStartDay(int startDay) {

        this.startDay = startDay;
    }

    public void setStartMonth(int startMonth) {

        this.startMonth = startMonth;
    }

    public void setStartYear(int startYear) {

        this.startYear = startYear;
    }
}
