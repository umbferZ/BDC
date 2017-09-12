/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Map
 * Last update: 13-set-2017 0.26.51
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

    private String           name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "map")
    private List<Source>     sources;

    /**
     * Instantiates a new map.
     */
    public Map() {
        this.clumps = new ArrayList<>();
        this.sources = new ArrayList<>();
        this.instruments = new ArrayList<>();
    }

    /**
     * Instantiates a new map.
     *
     * @param name the name
     */
    public Map(String name) {
        this.name = name;
    }

    public void addClump(Clump clump) {
        this.clumps.add(clump);

    }

    /**
     * Gets the clumps.
     *
     * @return the clumps
     */
    public List<Clump> getClumps() {
        return this.clumps;
    }

    public int getId() {
        return this.id;
    }

    /**
     * Gets the strumenti.
     *
     * @return the strumenti
     */
    public List<Instrument> getInstruments() {
        return this.instruments;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getName() {
        return this.name;
    }

    public List<Source> getSources() {
        return this.sources;
    }

    /**
     * Sets the clumps.
     *
     * @param clumps the new clumps
     */
    public void setClumps(List<Clump> clumps) {
        this.clumps = clumps;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the strumenti.
     *
     * @param instruments the new strumenti
     */
    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    /**
     * Sets the nome.
     *
     * @param name the new nome
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}