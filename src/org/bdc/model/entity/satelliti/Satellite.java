/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.satelliti
 * Type: Satellite
 * Last update: 10-mar-2017 15.47.30
 * 
 */

package org.bdc.model.entity.satelliti;

import java.util.ArrayList;
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
public class Satellite {

    private String agenzia;

    @Temporal(TemporalType.DATE)
    private Calendar fine;

    @Temporal(TemporalType.DATE)
    private Calendar inizio;

    @Id
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "satellite")
    private List<Strumento> strumenti;

    /**
     * Instantiates a new satellite.
     */
    public Satellite() {}

    /**
     * Instantiates a new satellite.
     *
     * @param nome the nome
     * @param agenzia the agenzia
     * @param inizio the inizio
     * @param fine the fine
     */
    public Satellite(String nome, String agenzia, Calendar inizio, Calendar fine) {
        this.nome = nome;
        this.agenzia = agenzia;
        this.inizio = inizio;
        this.fine = fine;
        strumenti = new ArrayList<>();
    }

    /**
     * Adds the strumento.
     *
     * @param strumento the strumento
     */
    public void addStrumento(Strumento strumento) {

        strumenti.add(strumento);
    }

    /**
     * Gets the agenzie.
     *
     * @return the agenzie
     */
    public String getAgenzie() {

        return agenzia;
    }

    /**
     * Gets the fine.
     *
     * @return the fine
     */
    public Calendar getFine() {

        return fine;
    }

    /**
     * Gets the inizio.
     *
     * @return the inizio
     */
    public Calendar getInizio() {

        return inizio;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {

        return nome;
    }

    /**
     * Sets the agenzie.
     *
     * @param agenzie the new agenzie
     */
    public void setAgenzie(String agenzie) {

        agenzia = agenzie;
    }

    /**
     * Sets the fine.
     *
     * @param fine the new fine
     */
    public void setFine(Calendar fine) {

        this.fine = fine;
    }

    /**
     * Sets the inizio.
     *
     * @param inizio the new inizio
     */
    public void setInizio(Calendar inizio) {

        this.inizio = inizio;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {

        this.nome = nome;
    }

}