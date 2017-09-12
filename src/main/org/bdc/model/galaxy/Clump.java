/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Clump
 * Last update: 9-set-2017 13.39.03
 * 
 */

package main.org.bdc.model.galaxy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The Class Clump.
 */
@Entity
public class Clump {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clump")
    private ClumpDetails  clumpDetails;

    @OneToMany(mappedBy = "clump")
    private List<Ellipse> ellispses;

    @Id
    private int           id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Map           map;

    private int massa;

    /**
     * Instantiates a new clump.
     */
    public Clump() {
        ellispses = new ArrayList<>();
    }

    public Clump(Map map, ClumpDetails clumpDetails) {
        super();
        this.map = map;
        this.clumpDetails = clumpDetails;
    }

    /**
     * Adds the ellipse.
     *
     * @param ellipse the ellipse
     */
    public void addEllipse(Ellipse ellipse) {
        ellispses.add(ellipse);
    }

    public ClumpDetails getClumpDetails() {
        return clumpDetails;
    }

    /**
     * Gets the ellispses.
     *
     * @return the ellispses
     */
    public List<Ellipse> getEllispses() {
        return ellispses;
    }

    /**
     * Gets the ellisse.
     *
     * @return the ellisse
     */
    public List<Ellipse> getEllisse() {
        return ellispses;
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

    public void setClumpDetails(ClumpDetails clumpDetails) {
        this.clumpDetails = clumpDetails;
    }

    /**
     * Sets the ellispses.
     *
     * @param ellispses the new ellispses
     */
    public void setEllispses(List<Ellipse> ellispses) {
        this.ellispses = ellispses;
    }

    /**
     * Sets the ellisse.
     *
     * @param ellipses the new ellisse
     */
    public void setEllisse(List<Ellipse> ellipses) {
        ellispses = ellipses;
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

    public int getMassa(){
        return this.massa;
    }

    public void setMassa(int massa){
        this.massa = massa;
    }
}