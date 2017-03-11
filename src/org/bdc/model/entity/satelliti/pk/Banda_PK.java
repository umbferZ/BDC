/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.satelliti.pk
 * Type: Banda_PK
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.model.entity.satelliti.pk;

import java.io.Serializable;

/**
 * The Class Banda_PK.
 */
public class Banda_PK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected double lunghezzaOnda;

    protected double risoluzione;

    protected Strumento_PK strumento;

    /**
     * Instantiates a new banda PK.
     */
    public Banda_PK() {}

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
     * Gets the strumento.
     *
     * @return the strumento
     */
    public Strumento_PK getStrumento() {

        return strumento;
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
     * Sets the strumento.
     *
     * @param strumento the new strumento
     */
    public void setStrumento(Strumento_PK strumento) {

        this.strumento = strumento;
    }

}