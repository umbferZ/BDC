/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Clump
 * Last update: 8-set-2017 18.23.00
 * 
 */

package main.org.bdc.model.galaxy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * The Class Clump.
 */
@Entity
public class Clump {

    // @Enumerated(EnumType.ORDINAL)
    private int           clumpType;

    private double        densita;

    @ManyToMany(mappedBy = "clump")
    private List<Ellipse> ellispses;

    @Id
    // @GeneratedValue
    private int           id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Map           map;

    // @ManyToMany
    // private List<Map> mappeStellari;
    @Transient
    private double        massa;

    @Embedded
    private Posizione     posizione;

    private double        rapportoMassaTemperatura;

    private double        temperatura;

    /**
     * Instantiates a new clump.
     */
    public Clump() {
        ellispses = new ArrayList<>();
    }

    public void addEllipse(Ellipse ellipse) {
        ellispses.add(ellipse);
    }

    /**
     * Gets the tipo clump.
     *
     * @return the tipo clump
     */
    public int getClumpType() {
        return clumpType;
    }

    /**
     * Gets the densita.
     *
     * @return the densita
     */
    public double getDensita() {
        return densita;
    }

    public List<Ellipse> getEllispses() {
        return ellispses;
    }

    /**
     * Gets the ellispses.
     *
     * @return the ellispses
     */
    public List<Ellipse> getEllisse() {
        return ellispses;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    public Map getMap() {
        return map;
    }

    public double getMassa() {
        int D = 10;
        int S350 = 350;
        massa = 0.053 * S350 * (D ^ 2) * (Math.exp(41.14 / temperatura) - 1);
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

    public double getRapportoMassaTemperatura() {
        return rapportoMassaTemperatura;
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
     * Sets the tipo clump.
     *
     * @param clumpType the new tipo clump
     */
    public void setClumpType(int clumpType) {
        this.clumpType = clumpType;
    }

    /**
     * Sets the densita.
     *
     * @param densita the new densita
     */
    public void setDensita(double densita) {
        this.densita = densita;
    }

    public void setEllispses(List<Ellipse> ellispses) {
        this.ellispses = ellispses;
    }

    /**
     * Sets the ellispses.
     *
     * @param ellispses the new ellispses
     */
    public void setEllisse(List<Ellipse> ellipses) {
        ellispses = ellipses;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setMap(Map map) {
        this.map = map;
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

    public void setRapportoMassaTemperatura(double rapportoMassaTemperatura) {
        this.rapportoMassaTemperatura = rapportoMassaTemperatura;
    }

    /**
     * Sets the temperatura.
     *
     * @param temperatura the new temperatura
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}