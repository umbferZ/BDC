/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Satellite
 * Last update: 8-set-2017 15.55.28
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
        this.instruments = new ArrayList<>();
        this.startDate = Calendar.getInstance();
        this.endDate = Calendar.getInstance();

    }

    /**
     * Instantiates a new satellite.
     *
     * @param name the name
     * @param agency the agency
     * @param startDate the startDate
     * @param endDate the endDate
     */
    public Satellite(String name, Agency agenzia, Calendar startDate, Calendar endDate) {
        this();
        this.name = name;
        this.agency = agenzia;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    /**
     * Adds the instrument.
     *
     * @param instrument the instrument
     */
    public void addStrumento(Instrument strument) {
        this.instruments.add(strument);
    }

    /**
     * Gets the agenzie.
     *
     * @return the agenzie
     */
    public Agency getAgenzia() {
        return this.agency;
    }

    /**
     * Gets the endDate.
     *
     * @return the endDate
     */
    public Calendar getEndDate() {
        return this.endDate;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the startDate.
     *
     * @return the startDate
     */
    public Calendar getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the agenzie.
     *
     * @param agenzie the new agenzie
     */
    public void setAgenzia(Agency agenzia) {
        this.agency = agenzia;
    }

    /**
     * Sets the endDate.
     *
     * @param endDate the new endDate
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    /**
     * Sets the endDate.
     *
     * @param year the year
     * @param monthOfYear the month of year
     * @param dayOfMonth the day of month
     */
    public void setEndDate(int year, int monthOfYear, int dayOfMonth) {
        this.endDate.set(year, monthOfYear - 1, dayOfMonth);
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
     * Sets the startDate.
     *
     * @param startDate the new startDate
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(int year, int monthOfYear, int dayOfMonth) {
        this.startDate.set(year, monthOfYear - 1, dayOfMonth);
    }
}