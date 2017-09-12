/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Flow
 * Last update: 13-set-2017 0.26.51
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import main.org.bdc.model.instruments.Band;

/**
 * The Class Flow.
 */
@Entity
public class Flow implements Serializable {

    @Id
    @GeneratedValue
    public int     id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Band   band;

    private double error;

    private double value;

    /**
     * Instantiates a new flusso.
     */
    public Flow() {}

    /**
     * Instantiates a new flow.
     *
     * @param value the value
     * @param band the band
     */
    public Flow(double value, Band band) {
        this(value, 0.0, band);
    }

    /**
     * Instantiates a new flow.
     *
     * @param value the value
     * @param error the error
     * @param band the band
     */
    public Flow(double value, double error, Band band) {
        this.value = value;
        this.error = error;
        this.band = band;
    }

    /**
     * Gets the band.
     *
     * @return the band
     */
    public Band getBanda() {
        return this.band;
    }

    /**
     * Gets the error.
     *
     * @return the error
     */
    public double getError() {
        return this.error;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Sets the band.
     *
     * @param band the new band
     */
    public void setBanda(Band banda) {
        this.band = banda;
    }

    /**
     * Sets the error.
     *
     * @param error the new error
     */
    public void setError(double error) {
        this.error = error;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(double value) {
        this.value = value;
    }
}