/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Flusso
 * Last update: 9-set-2017 13.41.47
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Flusso.
 */
@Entity
public class Flusso {

    @Id
    @GeneratedValue
    public int     id;

    // @ManyToOne
    // public Instrument strumento;

    @ManyToOne
    private Band   banda;

    private double errore;

    private double valore;

    /**
     * Instantiates a new flusso.
     */
    public Flusso() {}

    /**
     * Instantiates a new flusso.
     *
     * @param value the value
     * @param band the band
     */
    public Flusso(double value, Band band) {
        valore = value;
        banda = band;
    }

    /**
     * Gets the banda.
     *
     * @return the banda
     */
    public Band getBanda() {
        return banda;
    }

    /**
     * Gets the errore.
     *
     * @return the errore
     */
    public double getErrore() {
        return errore;
    }

    // /**
    // * Gets the instrument.
    // *
    // * @return the instrument
    // */
    // public Instrument getStrumento() {
    // return strumento;
    // }

    /**
     * Gets the valore.
     *
     * @return the valore
     */
    public double getValore() {
        return valore;
    }

    /**
     * Sets the banda.
     *
     * @param banda the new banda
     */
    public void setBanda(Band banda) {
        this.banda = banda;
    }

    /**
     * Sets the errore.
     *
     * @param errore the new errore
     */
    public void setErrore(double errore) {
        this.errore = errore;
    }

    // /**
    // * Sets the instrument.
    // *
    // * @param instrument the new instrument
    // */
    // public void setStrumento(Instrument strumento) {
    // this.strumento = strumento;
    // }

    /**
     * Sets the valore.
     *
     * @param valore the new valore
     */
    public void setValore(double valore) {
        this.valore = valore;
    }
}