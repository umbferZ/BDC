/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Satellite
 * Last update: 9-set-2017 12.51.22
 * 
 */

package main.org.bdc.model.galaxy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.Nullable;

/**
 * The Class Satellite.
 */
@Entity
public class Satellite {

    @OneToOne(cascade = CascadeType.ALL)
    private Agency           agency;

    @Temporal(TemporalType.DATE)
    @Nullable
    private Calendar         endDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "satellite")
    private List<Instrument> instruments;

    @Id
    private String           name;

    @Temporal(TemporalType.DATE)
    private Calendar         startDate;

    /**
     * Instantiates a new satellite.
     */
    public Satellite() {
        instruments = new ArrayList<>();
        startDate = Calendar.getInstance();
        endDate = Calendar.getInstance();

    }

    /**
     * Instantiates a new satellite.
     *
     * @param name the name
     * @param agenzia the agenzia
     * @param startDate the start date
     * @param endDate the end date
     */
    public Satellite(String name, Agency agenzia, Calendar startDate, Calendar endDate) {
        this();
        this.name = name;
        agency = agenzia;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    /**
     * Adds the strumento.
     *
     * @param strument the strument
     */
    public void addStrumento(Instrument strument) {
        instruments.add(strument);
    }

    /**
     * Gets the agenzia.
     *
     * @return the agenzia
     */
    public Agency getAgenzia() {
        return agency;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the agenzia.
     *
     * @param agenzia the new agenzia
     */
    public void setAgenzia(Agency agenzia) {
        agency = agenzia;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    /**
     * Sets the end date.
     *
     * @param year the year
     * @param monthOfYear the month of year
     * @param dayOfMonth the day of month
     */
    public void setEndDate(int year, int monthOfYear, int dayOfMonth) {
        endDate.set(year, monthOfYear - 1, dayOfMonth);
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets the start date.
     *
     * @param year the year
     * @param monthOfYear the month of year
     * @param dayOfMonth the day of month
     */
    public void setStartDate(int year, int monthOfYear, int dayOfMonth) {
        startDate.set(year, monthOfYear - 1, dayOfMonth);
    }
}