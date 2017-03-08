/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Strumento
 * Last update: 8-mar-2017 14.11.14
 * 
 */
package org.bdc.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.bdc.model.entity.pk.Strumento_PK;

/**
 * The Class Strumento.
 */
@Entity
// @IdClass(Strumento_PK.class)
public class Strumento {

    @OneToMany(mappedBy = "strumento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Banda> bandeOperative;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MappaStellare mappaStellare;

    @Id
    private String nome;

    // @Id
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SatelliteStrumento", joinColumns = @JoinColumn(name = "nome"), inverseJoinColumns = @JoinColumn(name = "satellite"))
    private List<Satellite> satelliti;

    /**
     * Instantiates a new strumento.
     */
    public Strumento() {}

    public Strumento(String nome, List<Satellite> satellite) {
        super();
        this.nome = nome;
        this.satelliti = satellite;
    }

}