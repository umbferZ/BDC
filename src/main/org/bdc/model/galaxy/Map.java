/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Map
 * Last update: 11-set-2017 23.56.56
 * 
 */

package main.org.bdc.model.galaxy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import main.org.bdc.model.instruments.Instrument;

/**
 * The Class Map.
 */
@Entity
// @IdClass(Map_PK.class) // todo PRIMARY KEY (?,?)
public class Map {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "map")
    private List<Clump>      clumps;

    @OneToMany(mappedBy = "map")
    private List<Instrument> instruments;

    @Id
    private String           name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "map")
    private List<Source>     sources;

    /**
     * Instantiates a new map.
     */
    public Map() {}

    /**
     * Instantiates a new map.
     *
     * @param name the name
     */
    public Map(String name) {
        this.name = name;
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
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return name;
    }

    /**
     * Gets the strumenti.
     *
     * @return the strumenti
     */
    public List<Instrument> getStrumenti() {
        return instruments;
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
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        name = nome;
    }

    /**
     * Sets the strumenti.
     *
     * @param strumenti the new strumenti
     */
    public void setStrumenti(List<Instrument> strumenti) {
        instruments = strumenti;
    }
}