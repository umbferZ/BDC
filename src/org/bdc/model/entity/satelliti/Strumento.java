/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.satelliti
 * Type: Strumento
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity.satelliti;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Transient;

import org.bdc.model.entity.pk.Strumento_PK;

/**
 * The Class Strumento.
 */
@Entity
// @IdClass(Strumento_PK.class)
public class Strumento {

    // @OneToMany(mappedBy = "strumento", cascade = CascadeType.ALL, fetch =
    // FetchType.LAZY)
    // private List<Banda> bandeOperative;

    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private MappaStellare mappaStellare;

    @Transient
    private String nome;

    @EmbeddedId
    private Strumento_PK pk;

    @MapsId("satellite_sd")
    @ManyToOne
    private Satellite satellite;

    /**
     * Instantiates a new strumento.
     */
    public Strumento() {}

    public Strumento(String nome) {
        this.nome = nome;
    }

    public Strumento(String nome, Satellite sat) {
        super();
        this.nome = nome;
        satellite = sat;
    }

    public String getNome() {
        return nome;
    }

    public Strumento_PK getPk() {
        return pk;
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPk(Strumento_PK pk) {
        this.pk = pk;
    }

    // public Strumento(String nome, Satellite satellite) {
    // this.nome = nome;
    // satelliti = new ArrayList<>();
    // satelliti.add(satellite);
    // }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }

}