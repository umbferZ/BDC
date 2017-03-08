/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Satellite
 * Last update: 8-mar-2017 9.36.51
 * 
 */
package org.bdc.model.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Satellite.
 */
@Entity
public class Satellite {
    @Enumerated(EnumType.STRING)
    private Agenzia agenzie;

    private Calendar fine;

    private Calendar inizio;

    @Id
    private String nome;

    @OneToMany(mappedBy = "satellite", cascade = CascadeType.ALL)
    private List<Strumento> strumenti;

    /**
     * Instantiates a new satellite.
     */
    public Satellite() {}

    public Satellite(String nome, Agenzia agenzie, Calendar inizio, Calendar fine) {
        super();
        this.nome = nome;
        this.agenzie = agenzie;
        this.inizio = inizio;
        this.fine = fine;
    }

}