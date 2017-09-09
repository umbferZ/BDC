/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Sorgent
 * Last update: 9-set-2017 13.43.13
 * 
 */

package main.org.bdc.model.galaxy;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Sorgent.
 */
@Entity
public class Sorgent {

    @OneToMany
    private List<Flusso> flussi;

    @Id
    @GeneratedValue
    private int          id;

    private double       luminosità;

    /**
     * Instantiates a new sorgente.
     */
    public Sorgent() {}

    /**
     * Gets the flussi.
     *
     * @return the flussi
     */
    public List<Flusso> getFlussi() {
        return flussi;
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
     * Gets the luminosità.
     *
     * @return the luminosità
     */
    public double getLuminosità() {
        return luminosità;
    }

    /**
     * Sets the flusso.
     *
     * @param flussi the new flusso
     */
    public void setFlusso(List<Flusso> flussi) {
        this.flussi = flussi;
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
     * Sets the luminosità.
     *
     * @param luminosità the new luminosità
     */
    public void setLuminosità(double luminosità) {
        this.luminosità = luminosità;
    }
}