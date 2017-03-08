/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Strumento
 * Last update: 8-mar-2017 9.36.51
 * 
 */
package org.bdc.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Strumento.
 */
@Entity
public class Strumento {

    @OneToMany(mappedBy = "strumento")
    private List<Banda> bandeOperative;

    @ManyToOne(cascade = CascadeType.ALL)
    private MappaStellare mappaStellare;

    @Id
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    private Satellite satellite;

    /**
     * Instantiates a new strumento.
     */
    public Strumento() {}

    public Strumento(String nome, Satellite satellite) {
        super();
        this.nome = nome;
        this.satellite = satellite;
    }

}