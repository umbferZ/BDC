/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Banda
 * Last update: 7-mar-2017 16.13.49
 * 
 */
package org.bdc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Banda.
 */
@Entity
public class Banda {

    @ManyToOne
    private Strumento strumento;
    @Id
    private double lunghezzaOnda;

    @Id
    private double risoluzione;

    /**
     * Instantiates a new banda.
     */
    public Banda() {}

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

}