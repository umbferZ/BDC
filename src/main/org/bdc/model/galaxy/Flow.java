/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Flow
 * Last update: 20-set-2017 13.23.23
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Band   band;

    private double error;

    private double value;

    /**
     * Instantiates a new flow.
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
     * Instantiates a new flow.
     *
     * @param v the v
     */
    public Flow(float v) {}

    /**
     * Gets the banda.
     *
     * @return the banda
     */
    public Band getBanda() {
        return band;
    }

    /**
     * Gets the error.
     *
     * @return the error
     */
    public double getError() {
        return error;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the banda.
     *
     * @param banda the new banda
     */
    public void setBanda(Band banda) {
        band = banda;
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