/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.satelliti
 * Type: Strumento
 * Last update: 10-mar-2017 15.47.30
 * 
 */

package org.bdc.model.entity.satelliti;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.bdc.model.entity.satelliti.pk.Strumento_PK;

/**
 * The Class Strumento.
 */
@Entity
@IdClass(Strumento_PK.class)
public class Strumento {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "strumento")
    private List<Banda> bandeOperative;

    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private MappaStellare mappaStellare;

    private String data1;

    private String data2;

    private String data3;

    @Id
    private String nome;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Satellite satellite;

    /**
     * Instantiates a new strumento.
     */
    public Strumento() {}

    /**
     * Instantiates a new strumento.
     *
     * @param nome the nome
     */
    public Strumento(String nome) {
        this(nome, null);

    }

    /**
     * Instantiates a new strumento.
     *
     * @param nome the nome
     * @param sat the sat
     */
    public Strumento(String nome, Satellite sat) {
        super();
        this.nome = nome;
        satellite = sat;
        bandeOperative = new ArrayList<>();
    }

    /**
     * Adds the banda operativa.
     *
     * @param banda the banda
     */
    public void addBandaOperativa(Banda banda) {

        bandeOperative.add(banda);
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
     * Gets the satellite.
     *
     * @return the satellite
     */
    public Satellite getSatellite() {

        return satellite;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {

        this.nome = nome;
    }

    /**
     * Sets the satellite.
     *
     * @param satellite the new satellite
     */
    public void setSatellite(Satellite satellite) {

        this.satellite = satellite;
    }

}