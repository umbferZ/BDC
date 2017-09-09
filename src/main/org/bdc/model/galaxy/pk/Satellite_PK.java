/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Satellite_PK
 * Last update: 9-set-2017 12.50.58
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
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {

        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {

        this.nome = nome;
    }

}
