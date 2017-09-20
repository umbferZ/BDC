/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls.gestisciSatellite
 * Type: BeanInserisciSatellite
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.controls.gestisciSatellite;

/**
 * The Class BeanInserisciSatellite.
 */
public class BeanInserisciSatellite {

    private String nomeSatellite, agenziaSatellite;

    private int    startDay, startMonth, startYear, endDay, endMonth, endYear;

    /**
     * Gets the agenzia satellite.
     *
     * @return the agenzia satellite
     */
    public String getAgenziaSatellite() {

        return agenziaSatellite;
    }

    /**
     * Gets the end day.
     *
     * @return the end day
     */
    public int getEndDay() {

        return endDay;
    }

    /**
     * Gets the end month.
     *
     * @return the end month
     */
    public int getEndMonth() {

        return endMonth;
    }

    /**
     * Gets the end year.
     *
     * @return the end year
     */
    public int getEndYear() {

        return endYear;
    }

    /**
     * Gets the nome satellite.
     *
     * @return the nome satellite
     */
    public String getNomeSatellite() {

        return nomeSatellite;
    }

    /**
     * Gets the start day.
     *
     * @return the start day
     */
    public int getStartDay() {

        return startDay;
    }

    /**
     * Gets the start month.
     *
     * @return the start month
     */
    public int getStartMonth() {

        return startMonth;
    }

    /**
     * Gets the start year.
     *
     * @return the start year
     */
    public int getStartYear() {

        return startYear;
    }

    /**
     * Sets the agenzia satellite.
     *
     * @param agenziaSatellite the new agenzia satellite
     */
    public void setAgenziaSatellite(String agenziaSatellite) {

        this.agenziaSatellite = agenziaSatellite;
    }

    /**
     * Sets the end date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public void setEndDate(int year, int month, int day) {
        endYear = year;
        endMonth = month;
        endDay = day;
    }

    /**
     * Sets the end day.
     *
     * @param endDay the new end day
     */
    public void setEndDay(int endDay) {

        this.endDay = endDay;
    }

    /**
     * Sets the end month.
     *
     * @param endMonth the new end month
     */
    public void setEndMonth(int endMonth) {

        this.endMonth = endMonth;
    }

    /**
     * Sets the end year.
     *
     * @param endYear the new end year
     */
    public void setEndYear(int endYear) {

        this.endYear = endYear;
    }

    /**
     * Sets the nome satellite.
     *
     * @param nomeSatellite the new nome satellite
     */
    public void setNomeSatellite(String nomeSatellite) {

        this.nomeSatellite = nomeSatellite;
    }

    /**
     * Sets the start date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public void setStartDate(int year, int month, int day) {
        startYear = year;
        startMonth = month;
        startDay = day;
    }

    /**
     * Sets the start day.
     *
     * @param startDay the new start day
     */
    public void setStartDay(int startDay) {

        this.startDay = startDay;
    }

    /**
     * Sets the start month.
     *
     * @param startMonth the new start month
     */
    public void setStartMonth(int startMonth) {

        this.startMonth = startMonth;
    }

    /**
     * Sets the start year.
     *
     * @param startYear the new start year
     */
    public void setStartYear(int startYear) {

        this.startYear = startYear;
    }
}
