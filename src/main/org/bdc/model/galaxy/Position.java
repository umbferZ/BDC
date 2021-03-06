/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Position
 * Last update: 20-set-2017 13.23.24
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
     * Instantiates a new position.
     */
    public Position() {}

    /**
     * Instantiates a new position.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     */
    public Position(double latitude, double longitude) {
        this(latitude, longitude, null);
    }

    /**
     * Instantiates a new position.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @param source the source
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
        return this.latitude;
    }

    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Gets the source.
     *
     * @return the source
     */
    public Source getSource() {
        return this.source;
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

    /**
     * Sets the source.
     *
     * @param source the new source
     */
    public void setSource(Source source) {
        this.source = source;
    }
}