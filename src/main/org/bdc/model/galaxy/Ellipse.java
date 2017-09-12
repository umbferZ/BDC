/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Ellipse
 * Last update: 13-set-2017 0.26.51
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import main.org.bdc.model.galaxy.pk.Ellipse_PK;
import main.org.bdc.model.instruments.Band;

/**
 * The Class Ellipse.
 */
@Entity
@IdClass(Ellipse_PK.class)
public class Ellipse implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Band   band;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Clump  clump;

    private double rotazione;

    private double xAss;

    private double yAss;

    /**
     * Instantiates a new ellipse.
     */
    public Ellipse() {}

    /**
     * Instantiates a new ellipse.
     *
     * @param xAss the x ass
     * @param yAss the y ass
     * @param rotazione the rotazione
     * @param band the band
     * @param clump the clump
     */
    public Ellipse(double xAss, double yAss, double rotazione, Band band, Clump clump) {
        this.xAss = xAss;
        this.yAss = yAss;
        this.rotazione = rotazione;
        // this.band = band;
        this.clump = clump;
    }

    /**
     * Gets the band.
     *
     * @return the band
     */
    public Band getBand() {
        return this.band;
    }

    public Clump getClump() {
        return this.clump;
    }

    /**
     * Gets the rotazione.
     *
     * @return the rotazione
     */
    public double getRotazione() {
        return this.rotazione;
    }

    public double getxAss() {
        return this.xAss;
    }

    /**
     * Gets the x ass.
     *
     * @return the x ass
     */
    public double getXAss() {
        return this.xAss;
    }

    public double getyAss() {
        return this.yAss;
    }

    /**
     * Gets the y ass.
     *
     * @return the y ass
     */
    public double getYAss() {
        return this.yAss;
    }

    /**
     * Sets the band.
     *
     * @param band the new band
     */
    public void setBand(Band band) {
        this.band = band;
    }

    public void setClump(Clump clump) {
        this.clump = clump;
    }

    /**
     * Sets the rotazione.
     *
     * @param rotazione the new rotazione
     */
    public void setRotazione(double rotazione) {
        this.rotazione = rotazione;
    }

    public void setxAss(double xAss) {
        this.xAss = xAss;
    }

    /**
     * Sets the x ass.
     *
     * @param xAss the new x ass
     */
    public void setXAss(double xAss) {
        this.xAss = xAss;
    }

    public void setyAss(double yAss) {
        this.yAss = yAss;
    }

    /**
     * Sets the y ass.
     *
     * @param yAss the new y ass
     */
    public void setYAss(double yAss) {
        this.yAss = yAss;
    }
}