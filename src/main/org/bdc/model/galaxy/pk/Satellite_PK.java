/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.satelliti
 * Type: Satellite_PK
 * Last update: 12-mar-2017 16.17.40
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * The Class Satellite_PK.
 */
@Embeddable
public class Satellite_PK implements Serializable {

    protected String nome;

    /**
     * Instantiates a new satellite PK.
     */
    public Satellite_PK() {}

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getNome() {

        return nome;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setNome(String nome) {

        this.nome = nome;
    }

}
