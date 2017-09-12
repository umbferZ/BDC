/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Satellite_PK
 * Last update: 13-set-2017 0.27.04
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

        return this.nome;
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
