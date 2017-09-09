/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Ellipse
 * Last update: 8-set-2017 17.56.07
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * The Class Ellipse.
 */
@Entity
public class Ellipse {

    @OneToOne
    private Band   banda;

    @OneToOne
    private Clump  clump;

    @Id
    @GeneratedValue
    private int    id;

    private double rotazione;

    private double xAss;

    private double yAss;

    /**
     * Instantiates a new ellisse.
     */
    public Ellipse() {}

    public Ellipse(double xAss, double yAss, double rotazione, Band banda, Clump clump) {
        super();
        this.xAss = xAss;
        this.yAss = yAss;
        this.rotazione = rotazione;
        this.banda = banda;
        this.clump = clump;
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
    public void setBanda(Band banda) {
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