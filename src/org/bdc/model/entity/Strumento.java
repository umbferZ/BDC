/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Strumento
 * Last update: 7-mar-2017 16.13.49
 * 
 */
package org.bdc.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Strumento.
 */
@Entity
public class Strumento {

    @Id
    private String nome;

    @ManyToOne
    private Satellite satellite;

    @OneToMany(mappedBy = "strumento")
    private List<Banda> bandeOperative;

    @ManyToOne
    private MappaStellare mappaStellare;

    /**
     * Instantiates a new strumento.
     */
    public Strumento() {}

}