/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.satelliti
 * Type: MappaStellare
 * Last update: 10-mar-2017 15.47.30
 * 
 */

package org.bdc.model.entity.satelliti;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.bdc.model.entity.Clump;

/**
 * The Class MappaStellare.
 */
@Entity
public class MappaStellare {

    @ManyToMany(mappedBy = "mappeStellari")
    private List<Clump> clumps;

    @Id
    private String nome;

    @OneToMany(mappedBy = "mappaStellare")
    private List<Strumento> strumenti;

    /**
     * Instantiates a new mappa stellare.
     */
    public MappaStellare() {}

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

        return nome;
    }

    /**
     * Gets the strumenti.
     *
     * @return the strumenti
     */
    public List<Strumento> getStrumenti() {

        return strumenti;
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

        this.nome = nome;
    }

    /**
     * Sets the strumenti.
     *
     * @param strumenti the new strumenti
     */
    public void setStrumenti(List<Strumento> strumenti) {

        this.strumenti = strumenti;
    }

}