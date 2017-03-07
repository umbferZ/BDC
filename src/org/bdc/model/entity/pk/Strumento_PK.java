package org.bdc.model.entity.pk;

import java.io.Serializable;

import org.bdc.model.entity.Satellite;

public class Strumento_PK implements Serializable {

    protected Satellite satellite;
    protected String nome;

    public Strumento_PK() {
        super();
    }

    public Strumento_PK(Satellite satellite, String nome) {
        super();
        this.satellite = satellite;
        this.nome = nome;
    }

}
