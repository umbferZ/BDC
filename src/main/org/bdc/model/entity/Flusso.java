/*
 *
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.entity
 * Type: Flusso
 * Last update: 12-mar-2017 16.21.07
 *
 */

package main.org.bdc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import main.org.bdc.model.entity.satelliti.Banda;
import main.org.bdc.model.entity.satelliti.Strumento;

/**
 * The Class Flusso.
 */
@Entity
public class Flusso {

    @ManyToOne
    public Strumento strumento;

    @ManyToOne
    private Banda banda;

    private double errore;

    @Id
    private double valore;

    /**
     * Instantiates a new flusso.
     */
    public Flusso() {}

    /**
     * Gets the banda.
     *
     * @return the banda
     */
    public Banda getBanda() {
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
     * Gets the strumento.
     *
     * @return the strumento
     */
    public Strumento getStrumento() {
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
    public void setBanda(Banda banda) {
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
     * Sets the strumento.
     *
     * @param strumento the new strumento
     */
    public void setStrumento(Strumento strumento) {
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