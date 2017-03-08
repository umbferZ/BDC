/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.pk
 * Type: Satellite_PK
 * Last update: 8-mar-2017 14.11.14
 * 
 */
package org.bdc.model.entity.pk;

import java.io.Serializable;

public class Satellite_PK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected String nome;

    public Satellite_PK() {}

    // @Override
    // public int hashCode() {
    // return nome.hashCode();
    // }
    //
    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Satellite_PK other = (Satellite_PK) obj;
    // if (nome == null) {
    // if (other.nome != null) {
    // this.nome = other.nome;
    // return true;
    // }
    // }
    // return false;
    // }

}
