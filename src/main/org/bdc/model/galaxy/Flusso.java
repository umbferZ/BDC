/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Flusso
 * Last update: 8-set-2017 17.48.54
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Flusso.
 */
@Entity
public class Flusso {

    @ManyToOne
    public Instrument strumento;

    @ManyToOne
    private Band      banda;

    private double    errore;

    @Id
    private double    valore;

    /**
     * Instantiates a new flusso.
     */
    public Flusso() {}

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

    /**
     * Gets the instrument.
     *
     * @return the instrument
     */
    public Instrument getStrumento() {
        return strumento;
    }

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

    /**
     * Sets the instrument.
     *
     * @param instrument the new instrument
     */
    public void setStrumento(Instrument strumento) {
        this.strumento = strumento;
    }

    /**
     * Sets the valore.
     *
     * @param valore the new valore
     */
    public void setValore(double valore) {
        this.valore = valore;
    }
}