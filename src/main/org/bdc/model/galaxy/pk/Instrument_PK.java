/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Instrument_PK
 * Last update: 9-set-2017 12.50.58
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

import javax.persistence.JoinColumn;

/**
 * The Class Instrument_PK.
 */
@Deprecated
public class Instrument_PK implements Serializable {

    protected String name;

    @JoinColumn(name = "satellite_name")
    protected String satellite;

    /**
     * Instantiates a new instrument PK.
     */
    public Instrument_PK() {}

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the satellite.
     *
     * @return the satellite
     */
    public String getSatellite() {
        return satellite;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the satellite.
     *
     * @param satellite the new satellite
     */
    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }
}