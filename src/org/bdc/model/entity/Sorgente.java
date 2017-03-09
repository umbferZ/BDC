/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Sorgente
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Sorgente.
 */
@Entity
public class Sorgente {

    @OneToMany
    private List<Flusso> flussi;

    @Id
    @GeneratedValue
    private String id;

    private double luminosità;

    /**
     * Instantiates a new sorgente.
     */
    public Sorgente() {}

    /**
     * Gets the flusso.
     *
     * @return the flusso
     */
    public List<Flusso> getFlussi() {
        return flussi;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the luminosità.
     *
     * @return the luminosità
     */
    public double getLuminosità() {
        return luminosità;
    }

    /**
     * Sets the flusso.
     *
     * @param flusso the new flusso
     */
    public void setFlusso(List<Flusso> flussi) {
        this.flussi = flussi;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the luminosità.
     *
     * @param luminosità the new luminosità
     */
    public void setLuminosità(double luminosità) {
        this.luminosità = luminosità;
    }

}