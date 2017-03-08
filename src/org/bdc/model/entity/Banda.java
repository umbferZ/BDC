/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Banda
 * Last update: 8-mar-2017 9.36.51
 * 
 */
package org.bdc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import org.bdc.model.entity.pk.Banda_PK;

/**
 * The Class Banda.
 */
@Entity
@IdClass(Banda_PK.class)
public class Banda {

    @Id
    private double lunghezzaOnda;
    @Id
    private double risoluzione;
    @ManyToOne
    private Strumento strumento;

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