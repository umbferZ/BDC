/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.instruments
 * Type: Band
 * Last update: 11-set-2017 22.59.58
 * 
 */

package main.org.bdc.model.instruments;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Band.
 */
@Entity
// @IdClass(Band_PK.class)
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int        id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Instrument instrument;

    private double     lunghezzaOnda;

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
        resolution = risoluzione;
        this.lunghezzaOnda = lunghezzaOnda;
    }

    /**
     * Instantiates a new band.
     *
     * @param resolution the resolution
     * @param lunghezzaOnda the lunghezza onda
     * @param instrument the instrument
     */
    public Band(double resolution, double lunghezzaOnda, Instrument instrument) {
        super();
        this.resolution = resolution;
        this.lunghezzaOnda = lunghezzaOnda;
        this.instrument = instrument;
    }

    /**
     * Gets the strument.
     *
     * @return the strument
     */
    public Instrument getInstrument() {
        return instrument;
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
    public double getResolution() {
        return resolution;
    }

    /**
     * Sets the strument.
     *
     * @param instrument the new strument
     */
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
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
    public void setResolution(double resolution) {
        this.resolution = resolution;
    }
}