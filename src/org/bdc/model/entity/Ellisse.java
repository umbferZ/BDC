/*
 *
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Ellisse
 * Last update: 12-mar-2017 16.21.05
 *
 */

package org.bdc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.bdc.model.entity.satelliti.Banda;

/**
 * The Class Ellisse.
 */
@Entity
public class Ellisse {

    @OneToOne
    private Banda banda;

    @OneToOne
    private Clump clump;

    @Id
    private int id;

    private double rotazione;

    private double xAss;

    private double yAss;

    /**
     * Instantiates a new ellisse.
     */
    public Ellisse() {}

    /**
     * Gets the banda.
     *
     * @return the banda
     */
    public Banda getBanda() {
        return banda;
    }

    /**
     * Gets the rotazione.
     *
     * @return the rotazione
     */
    public double getRotazione() {
        return rotazione;
    }

    /**
     * Gets the x ass.
     *
     * @return the x ass
     */
    public double getxAss() {
        return xAss;
    }

    /**
     * Gets the y ass.
     *
     * @return the y ass
     */
    public double getyAss() {
        return yAss;
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
     * Sets the rotazione.
     *
     * @param rotazione the new rotazione
     */
    public void setRotazione(double rotazione) {
        this.rotazione = rotazione;
    }

    /**
     * Sets the x ass.
     *
     * @param xAss the new x ass
     */
    public void setxAss(double xAss) {
        this.xAss = xAss;
    }

    /**
     * Sets the y ass.
     *
     * @param yAss the new y ass
     */
    public void setyAss(double yAss) {
        this.yAss = yAss;
    }
}