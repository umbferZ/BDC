/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Posizione
 * Last update: 8-mar-2017 14.11.14
 * 
 */
package org.bdc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.bdc.model.entity.pk.Posizione_PK;

/**
 * The Class Posizione.
 */
@Entity
@IdClass(Posizione_PK.class)
public class Posizione {
    @Id
    private double lat;
    @Id
    private double lon;

    /**
     * Instantiates a new posizione.
     */
    public Posizione() {}

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