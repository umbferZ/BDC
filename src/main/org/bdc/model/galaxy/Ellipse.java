/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Ellipse
 * Last update: 9-set-2017 13.39.09
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import main.org.bdc.model.galaxy.pk.Ellipse_PK;

/**
 * The Class Ellipse.
 */
@Entity
// todo PRIMARY KEY (band, clump)
@IdClass(Ellipse_PK.class)
public class Ellipse {

    @Id
    @OneToOne
    private Band   band;

    @Id
    @ManyToOne
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
    public Ellipse(double xAss, double yAss, double rotazione, Band banda, Clump clump) {
        super();
        this.xAss = xAss;
        this.yAss = yAss;
        this.rotazione = rotazione;
        band = banda;
        this.clump = clump;
    }

    /**
     * Gets the band.
     *
     * @return the band
     */
    public Band getBanda() {
        return band;
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
     * Sets the band.
     *
     * @param band the new band
     */
    public void setBanda(Band banda) {
        band = banda;
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