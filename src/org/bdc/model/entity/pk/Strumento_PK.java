/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.pk
 * Type: Strumento_PK
 * Last update: 8-mar-2017 9.36.51
 * 
 */
package org.bdc.model.entity.pk;

import java.io.Serializable;

import org.bdc.model.entity.Satellite;

public class Strumento_PK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected String nome;
    protected Satellite satellite;

    public Strumento_PK() {
        super();
    }

    public Strumento_PK(Satellite satellite, String nome) {
        super();
        this.satellite = satellite;
        this.nome = nome;
    }

}
