/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Band
 * Last update: 9-set-2017 13.24.51
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import main.org.bdc.model.galaxy.pk.Band_PK;

/**
 * The Class Band.
 */
@Entity
@IdClass(Band_PK.class)
public class Band {

    // @Id
    // @GeneratedValue
    // private int id; // todo remove this attribute

    // @JoinColumns({
    // @JoinColumn(name = "instrument_name", referencedColumnName = "name"),
    // @JoinColumn(name = "satellite_name", referencedColumnName =
    // "satellite_name")
    // })
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Instrument instrument;

    private double     lunghezzaOnda;

    @Id
    private double     resolution;

    /**
     * Instantiates a new band.
     */
    public Band() {}

    /**
     * Instantiates a new band.
     *
     * @param resolution the resolution
     * @param lunghezzaOnda the lunghezza onda
     */
    public Band(double risoluzione, double lunghezzaOnda) {
        this.resolution = risoluzione;
        this.lunghezzaOnda = lunghezzaOnda;
    }

    /**
     * Instantiates a new band.
     *
     * @param resolution the resolution
     * @param lunghezzaOnda the lunghezza onda
     * @param instrument the instrument
     */
    public Band(double risoluzione, double lunghezzaOnda, Instrument instrument) {
        super();
        this.resolution = risoluzione;
        this.lunghezzaOnda = lunghezzaOnda;
        this.instrument = instrument;
    }

    /**
     * Gets the lunghezza onda.
     *
     * @return the lunghezza onda
     */
    public double getLunghezzaOnda() {
        return lunghezzaOnda;
    }

    /**
     * Gets the resolution.
     *
     * @return the resolution
     */
    public double getRisoluzione() {
        return resolution;
    }

    /**
     * Gets the strument.
     *
     * @return the strument
     */
    public Instrument getStrument() {
        return instrument;
    }

    /**
     * Sets the lunghezza onda.
     *
     * @param lunghezzaOnda the new lunghezza onda
     */
    public void setLunghezzaOnda(double lunghezzaOnda) {
        this.lunghezzaOnda = lunghezzaOnda;
    }

    /**
     * Sets the resolution.
     *
     * @param resolution the new resolution
     */
    public void setRisoluzione(double risoluzione) {
        this.resolution = risoluzione;
    }

    /**
     * Sets the strument.
     *
     * @param instrument the new strument
     */
    public void setStrument(Instrument instrument) {
        this.instrument = instrument;
    }
}