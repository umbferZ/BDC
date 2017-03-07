/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Satellite
 * Last update: 7-mar-2017 16.13.49
 * 
 */
package org.bdc.model.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Satellite.
 */
@Entity
public class Satellite {
    @Id
    private String nome;

    @Enumerated
    private Agenzia agenzie;

    private Calendar fine;

    private Calendar inizio;

    @OneToMany(mappedBy = "satellite")
    private List<Strumento> strumenti;

    /**
     * Instantiates a new satellite.
     */
    public Satellite() {}

}