/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Map
 * Last update: 8-set-2017 17.11.33
 * 
 */

package main.org.bdc.model.galaxy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Map.
 */
@Entity
// @IdClass(Map_PK.class)
public class Map {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "map")
    private List<Clump>      clumps;

    @OneToMany(mappedBy = "map")
    private List<Instrument> instruments;

    @Id
    private String           name;

    /**
     * Instantiates a new mappa stellare.
     */
    public Map() {}

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
     * Gets the name.
     *
     * @return the name
     */
    public String getNome() {
        return name;
    }

    /**
     * Gets the instruments.
     *
     * @return the instruments
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
     * Sets the name.
     *
     * @param name the new name
     */
    public void setNome(String nome) {
        name = nome;
    }

    /**
     * Sets the instruments.
     *
     * @param instruments the new instruments
     */
    public void setStrumenti(List<Instrument> strumenti) {
        instruments = strumenti;
    }
}