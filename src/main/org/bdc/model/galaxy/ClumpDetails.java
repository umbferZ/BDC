/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: ClumpDetails
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import main.org.bdc.model.galaxy.pk.ClumpDetails_PK;

/**
 * The Class ClumpDetails.
 */
@Entity
@IdClass(ClumpDetails_PK.class)
public class ClumpDetails implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Clump  clump;

    private int    clumpType;

    private double densita;

    private double lat;

    private double lon;

    @Transient
    private double massa;

    private double rapportoMassaTemperatura;

    private double temperatura;

    /**
     * Instantiates a new clump details.
     */
    public ClumpDetails() {
        super();
    }

    /**
     * Instantiates a new clump details.
     *
     * @param clump the clump
     * @param clumpType the clump type
     * @param densita the densita
     * @param rapportoMassaTemperatura the rapporto massa temperatura
     * @param temperatura the temperatura
     * @param lat the lat
     * @param lon the lon
     */
    public ClumpDetails(Clump clump, int clumpType, double densita, double rapportoMassaTemperatura, double temperatura, double lat, double lon) {
        super();
        this.clump = clump;
        this.clumpType = clumpType;
        this.densita = densita;
        this.rapportoMassaTemperatura = rapportoMassaTemperatura;
        this.temperatura = temperatura;
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Gets the clump.
     *
     * @return the clump
     */
    public Clump getClump() {
        return clump;
    }

    /**
     * Gets the clump type.
     *
     * @return the clump type
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

    /**
     * Gets the lat.
     *
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * Gets the lon.
     *
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * Gets the massa.
     *
     * @return the massa
     */
    public double getMassa() {
        int D = 10;
        int S350 = 350;
        massa = 0.053 * S350 * (D ^ 2) * (Math.exp(41.14 / temperatura) - 1);
        return massa;
    }

    /**
     * Gets the rapporto massa temperatura.
     *
     * @return the rapporto massa temperatura
     */
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
     * Sets the clump.
     *
     * @param clump the new clump
     */
    public void setClump(Clump clump) {
        this.clump = clump;
    }

    /**
     * Sets the clump type.
     *
     * @param clumpType the new clump type
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

    /**
     * Sets the lat.
     *
     * @param lat the new lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Sets the lon.
     *
     * @param lon the new lon
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * Sets the massa.
     *
     * @param massa the new massa
     */
    public void setMassa(double massa) {
        this.massa = massa;
    }

    /**
     * Sets the rapporto massa temperatura.
     *
     * @param rapportoMassaTemperatura the new rapporto massa temperatura
     */
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
