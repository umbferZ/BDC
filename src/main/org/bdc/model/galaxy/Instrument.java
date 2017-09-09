/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Instrument
 * Last update: 9-set-2017 12.51.21
 * 
 */

package main.org.bdc.model.galaxy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Instrument.
 */
@Entity

public class Instrument {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "instrument")
    private List<Band> bands;

    @Id
    @GeneratedValue
    private int        id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Map        map;

    private String     name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Satellite  satellite;

    /**
     * Instantiates a new instrument.
     */
    public Instrument() {}

    /**
     * Instantiates a new instrument.
     *
     * @param name the name
     */
    public Instrument(String name) {
        this(name, null);
    }

    /**
     * Instantiates a new instrument.
     *
     * @param name the name
     * @param satellite the satellite
     */
    public Instrument(String name, Satellite satellite) {
        super();
        this.name = name;
        this.satellite = satellite;
        bands = new ArrayList<>();
    }

    /**
     * Adds the banda operativa.
     *
     * @param banda the banda
     */
    public void addBandaOperativa(Band banda) {
        bands.add(banda);

    }

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
    public Satellite getSatellite() {
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
    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }
}