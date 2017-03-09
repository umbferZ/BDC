/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Clump
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.bdc.model.entity.satelliti.MappaStellare;

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

    @ManyToMany
    private List<MappaStellare> mappeStellari;

    @OneToOne
    private Posizione posizione;

    private double tem_mas;

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

    /**
     * Gets the posizione.
     *
     * @return the posizione
     */
    public Posizione getPosizione() {
        return posizione;
    }

    /**
     * Gets the tem mas.
     *
     * @return the tem mas
     */
    public double getTem_mas() {
        return tem_mas;
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

    /**
     * Sets the posizione.
     *
     * @param posizione the new posizione
     */
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    /**
     * Sets the tem mas.
     *
     * @param tem_mas the new tem mas
     */
    public void setTem_mas(double tem_mas) {
        this.tem_mas = tem_mas;
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