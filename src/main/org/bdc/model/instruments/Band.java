/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.instruments
 * Type: Band
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.model.instruments;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import main.org.bdc.model.galaxy.Flow;

/**
 * The Class Band.
 */
@Entity
// @IdClass(Band_PK.class)
public class Band implements Serializable {

    @OneToMany(mappedBy = "band")
    private List<Flow> flows;

    @Id
    @GeneratedValue
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
    public Band(double resolution, double lunghezzaOnda) {
        this(resolution, lunghezzaOnda, null);
    }

    /**
     * Instantiates a new band.
     *
     * @param resolution the resolution
     */
    public Band(double resolution) {
        this.resolution = resolution;
    }

    /**
     * Instantiates a new band.
     *
     * @param resolution the resolution
     * @param lunghezzaOnda the lunghezza onda
     * @param instrument the instrument
     */
    public Band(double resolution, double lunghezzaOnda, Instrument instrument) {
        this.resolution = resolution;
        this.lunghezzaOnda = lunghezzaOnda;
        this.instrument = instrument;
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public List<Flow> getFlows() {
        return flows;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    // public void addInstrument(Instrument instrument) {
    // instruments.add(instrument);
    // }

    /**
     * Gets the instrument.
     *
     * @return the instrument
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
     * Sets the flows.
     *
     * @param flows the new flows
     */
    public void setFlows(List<Flow> flows) {
        this.flows = flows;
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
     * Sets the instrument.
     *
     * @param instrument the new instrument
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