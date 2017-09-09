/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Posizione
 * Last update: 9-set-2017 12.51.21
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.Embeddable;

/**
 * The Class Posizione.
 */
@Embeddable
public class Posizione {

    private double lat;

    private double lon;

    /**
     * Instantiates a new posizione.
     */
    public Posizione() {}

    /**
     * Instantiates a new posizione.
     *
     * @param lat the lat
     * @param lon the lon
     */
    public Posizione(double lat, double lon) {
        super();
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Gets the lat.
     *
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * Gets the lon.
     *
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * Sets the lat.
     *
     * @param lat the new lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Sets the lon.
     *
     * @param lon the new lon
     */
    public void setLon(double lon) {
        this.lon = lon;
    }
}