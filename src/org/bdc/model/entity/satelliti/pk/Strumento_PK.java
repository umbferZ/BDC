/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.satelliti.pk
 * Type: Strumento_PK
 * Last update: 10-mar-2017 15.48.00
 * 
 */

package org.bdc.model.entity.satelliti.pk;

import java.io.Serializable;

import javax.persistence.JoinColumn;

/**
 * The Class Strumento_PK.
 */
public class Strumento_PK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected String nome;

    @JoinColumn(name = "satellite_nome")
    protected String satellite;

    /**
     * Instantiates a new strumento PK.
     */
    public Strumento_PK() {}

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {

        return nome;
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
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {

        this.nome = nome;
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
