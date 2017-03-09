/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.pk
 * Type: Satellite_PK
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Satellite_PK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected String nome;

    public Satellite_PK() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
