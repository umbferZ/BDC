/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.instruments
 * Type: Instrument
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.model.instruments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Satellite;

/**
 * The Class Instrument.
 */
@Entity
public class Instrument implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "instrument")
    private List<Band> bands;

    @Id
    @GeneratedValue
    private int        id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Map        map;

    @Column(unique = true, nullable = false)
    private String     name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Satellite  satellite;

    /**
     * Instantiates a new instrument.
     */
    public Instrument() {
        bands = new ArrayList<>();
    }

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
        this();
        this.name = name;
        this.satellite = satellite;

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
     * Gets the bands.
     *
     * @return the bands
     */
    public List<Band> getBands() {
        return bands;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public Map getMap() {
        return map;
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
     * Sets the bands.
     *
     * @param bands the new bands
     */
    public void setBands(List<Band> bands) {
        this.bands = bands;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    public void setMap(Map map) {
        this.map = map;
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