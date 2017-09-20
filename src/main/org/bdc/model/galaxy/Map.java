/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Map
 * Last update: 20-set-2017 13.23.25
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import main.org.bdc.model.instruments.Instrument;

/**
 * The Class Map.
 */
@Entity
// @IdClass(Map_PK.class) // todo PRIMARY KEY (?,?)
public class Map implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "map")
    private List<Clump>      clumps;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int              id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "map")
    private List<Instrument> instruments;

    @Column(unique = true)
    private String           name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "map")
    private List<Source>     sources;

    /**
     * Instantiates a new map.
     */
    public Map() {
        clumps = new ArrayList<>();
        sources = new ArrayList<>();
        instruments = new ArrayList<>();
    }

    /**
     * Instantiates a new map.
     *
     * @param name the name
     */
    public Map(String name) {
        this.name = name;
    }

    /**
     * Adds the clump.
     *
     * @param clump the clump
     */
    public void addClump(Clump clump) {
        clumps.add(clump);

    }

    /**
     * Gets the clumps.
     *
     * @return the clumps
     */
    public List<Clump> getClumps() {
        return clumps;
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
     * Gets the instruments.
     *
     * @return the instruments
     */
    public List<Instrument> getInstruments() {
        return instruments;
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
     * Gets the sources.
     *
     * @return the sources
     */
    public List<Source> getSources() {
        return sources;
    }

    /**
     * Sets the clumps.
     *
     * @param clumps the new clumps
     */
    public void setClumps(List<Clump> clumps) {
        this.clumps = clumps;
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
     * Sets the instruments.
     *
     * @param instruments the new instruments
     */
    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
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
     * Sets the sources.
     *
     * @param sources the new sources
     */
    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}