/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.satelliti.pk
 * Type: Band_PK
 * Last update: 12-mar-2017 16.10.44
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

/**
 * The Class Band_PK.
 */
public class Band_PK implements Serializable {

    protected double lunghezzaOnda;

    protected double risoluzione;

    protected Instrument_PK instrument;

    /**
     * Instantiates a new banda PK.
     */
    public Band_PK() {}

    /**
     * Gets the lunghezza onda.
     *
     * @return the lunghezza onda
     */
    public double getLunghezzaOnda() {
        return lunghezzaOnda;
    }

    /**
     * Gets the risoluzione.
     *
     * @return the risoluzione
     */
    public double getRisoluzione() {
        return risoluzione;
    }

    /**
     * Gets the instrument.
     *
     * @return the instrument
     */
    public Instrument_PK getStrument() {
        return instrument;
    }

    /**
     * Sets the lunghezza onda.
     *
     * @param lunghezzaOnda the new lunghezza onda
     */
    public void setLunghezzaOnda(double lunghezzaOnda) {
        this.lunghezzaOnda = lunghezzaOnda;
    }

    /**
     * Sets the risoluzione.
     *
     * @param risoluzione the new risoluzione
     */
    public void setRisoluzione(double risoluzione) {
        this.risoluzione = risoluzione;
    }

    /**
     * Sets the instrument.
     *
     * @param instrument the new instrument
     */
    public void setStrument(Instrument_PK strument) {
        this.instrument = strument;
    }
}