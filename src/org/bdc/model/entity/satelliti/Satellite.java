/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.satelliti
 * Type: Satellite
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity.satelliti;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Satellite.
 */
@Entity
// @IdClass(Satellite_PK.class)
public class Satellite {

    private String agenzia;
    @Temporal(TemporalType.DATE)
    private Calendar fine;
    @Temporal(TemporalType.DATE)
    private Calendar inizio;

    @Id
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Strumento> strumenti;

    /**
     * Instantiates a new satellite.
     */
    public Satellite() {}

    public Satellite(String nome, String agenzie, Calendar inizio, Calendar fine) {
        super();
        this.nome = nome;
        agenzia = agenzie;
        this.inizio = inizio;
        this.fine = fine;
    }

    public String getAgenzie() {
        return agenzia;
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

    public void setAgenzie(String agenzie) {
        agenzia = agenzie;
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

}