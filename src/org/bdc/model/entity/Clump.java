/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Clump
 * Last update: 9-mar-2017 18.30.06
 * 
 */
package org.bdc.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * The Class Clump.
 */
@Entity
public class Clump {

    private double densita;

    @OneToOne(mappedBy = "clump")
    private Ellisse ellisse;

    @Id
    @GeneratedValue
    private int id;

    // @ManyToMany
    // private List<MappaStellare> mappeStellari;

    @Transient
    private double massa;

    @OneToOne
    private Posizione posizione;

    private double ratioMassaTemperatura;

    private double temperatura;

    @Enumerated(EnumType.STRING)
    private ClumpTipo tipoClump;

    /**
     * Instantiates a new clump.
     */
    public Clump() {}

    /**
     * Gets the densita.
     *
     * @return the densita
     */
    public double getDensita() {
        return densita;
    }

    /**
     * Gets the ellisse.
     *
     * @return the ellisse
     */
    public Ellisse getEllisse() {
        return ellisse;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    public double getMassa() {
        int D = 10;
        int S350 = 350;
        massa = 0.053 * (S350) * (D ^ 2) * (Math.exp(41.14 / temperatura) - 1);
        return massa;
    }

    /**
     * Gets the posizione.
     *
     * @return the posizione
     */
    public Posizione getPosizione() {
        return posizione;
    }

    public double getRatioMassaTemperatura() {
        return ratioMassaTemperatura;
    }

    /**
     * Gets the temperatura.
     *
     * @return the temperatura
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Gets the tipo clump.
     *
     * @return the tipo clump
     */
    public ClumpTipo getTipoClump() {
        return tipoClump;
    }

    /**
     * Sets the densita.
     *
     * @param densita the new densita
     */
    public void setDensita(double densita) {
        this.densita = densita;
    }

    /**
     * Sets the ellisse.
     *
     * @param ellisse the new ellisse
     */
    public void setEllisse(Ellisse ellisse) {
        this.ellisse = ellisse;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    /**
     * Sets the posizione.
     *
     * @param posizione the new posizione
     */
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public void setRatioMassaTemperatura(double ratioMassaTemperatura) {
        this.ratioMassaTemperatura = ratioMassaTemperatura;
    }

    /**
     * Sets the temperatura.
     *
     * @param temperatura the new temperatura
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Sets the tipo clump.
     *
     * @param tipoClump the new tipo clump
     */
    public void setTipoClump(ClumpTipo tipoClump) {
        this.tipoClump = tipoClump;
    }

}