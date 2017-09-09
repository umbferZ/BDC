/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: ClumpDetails
 * Last update: 9-set-2017 13.50.11
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import main.org.bdc.model.galaxy.pk.ClumpDetails_PK;

@Entity
@IdClass(ClumpDetails_PK.class)
public class ClumpDetails implements Serializable {

    @Id
    @OneToOne
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
        return clump;
    }

    public int getClumpType() {
        return clumpType;
    }

    public double getDensita() {
        return densita;
    }

    public double getMassa() {
        int D = 10;
        int S350 = 350;
        massa = 0.053 * S350 * (D ^ 2) * (Math.exp(41.14 / temperatura) - 1);
        return massa;
    }

    public double getRapportoMassaTemperatura() {
        return rapportoMassaTemperatura;
    }

    public double getTemperatura() {
        return temperatura;
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
