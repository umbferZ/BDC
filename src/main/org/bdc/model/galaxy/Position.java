/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Position
 * Last update: 11-set-2017 12.57.56
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;

import main.org.bdc.model.galaxy.pk.Position_PK;

/**
 * The Class Position.
 */
@Entity
@IdClass(Position_PK.class)
public class Position implements Serializable {

    private double latitude;

    private double longitude;

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Source source;

    /**
     * Instantiates a new posizione.
     */
    public Position() {}

    public Position(double latitude, double longitude) {
        this(latitude, longitude, null);
    }

    /**
     * Instantiates a new posizione.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     */
    public Position(double latitude, double longitude, Source source) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.source = source;
    }

    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the latitude.
     *
     * @param latitude the new latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets the longitude.
     *
     * @param longitude the new longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}