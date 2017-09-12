/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: ClumpDetails
 * Last update: 13-set-2017 0.26.51
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

    public ClumpDetails() {
        super();
    }

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

    public Clump getClump() {
        return this.clump;
    }

    public int getClumpType() {
        return this.clumpType;
    }

    public double getDensita() {
        return this.densita;
    }

    public double getMassa() {
        int D = 10;
        int S350 = 350;
        this.massa = 0.053 * S350 * (D ^ 2) * (Math.exp(41.14 / this.temperatura) - 1);
        return this.massa;
    }

    public double getRapportoMassaTemperatura() {
        return this.rapportoMassaTemperatura;
    }

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setClump(Clump clump) {
        this.clump = clump;
    }

    public void setClumpType(int clumpType) {
        this.clumpType = clumpType;
    }

    public void setDensita(double densita) {
        this.densita = densita;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public void setRapportoMassaTemperatura(double rapportoMassaTemperatura) {
        this.rapportoMassaTemperatura = rapportoMassaTemperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

}
