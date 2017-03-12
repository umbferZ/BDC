/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Posizione
 * Last update: 12-mar-2017 16.21.10
 * 
 */

package org.bdc.model.entity;

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