/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.pk
 * Type: Strumento_PK
 * Last update: 8-mar-2017 14.11.14
 * 
 */
package org.bdc.model.entity.pk;

import java.io.Serializable;

public class Strumento_PK implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */

    protected String nome;

    protected String satellite;

    // @Override
    // public int hashCode() {
    // return satellite.hashCode() * 31;
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
    // Strumento_PK other = (Strumento_PK) obj;
    // if (nome == null & satellite == null) {
    // if (other.nome != null && other.satellite != null) {
    // this.nome = other.nome;
    // this.satellite = other.satellite;
    // return true;
    // }
    // }
    // return false;
    //
    // }

    public Strumento_PK() {
        // satellite = new Satellite().getNome();
    }

}
