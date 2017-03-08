/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Satellite
 * Last update: 8-mar-2017 14.11.14
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
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.bdc.model.entity.pk.Satellite_PK;

/**
 * The Class Satellite.
 */
@Entity
// @IdClass(Satellite_PK.class)
public class Satellite {

    @Enumerated(EnumType.STRING)
    private Agenzia agenzie;

    private Calendar fine;

    private Calendar inizio;

    @Id
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
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

    public Agenzia getAgenzie() {
        return agenzie;
    }

    public Calendar getFine() {
        return fine;
    }

    public Calendar getInizio() {
        return inizio;
    }

    public String getNome() {
        return nome;
    }

    public List<Strumento> getStrumenti() {
        return strumenti;
    }

    public void setAgenzie(Agenzia agenzie) {
        this.agenzie = agenzie;
    }

    public void setFine(Calendar fine) {
        this.fine = fine;
    }

    public void setInizio(Calendar inizio) {
        this.inizio = inizio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStrumenti(List<Strumento> strumenti) {
        this.strumenti = strumenti;
    }

}