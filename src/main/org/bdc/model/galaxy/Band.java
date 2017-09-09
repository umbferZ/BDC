/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Band
 * Last update: 9-set-2017 11.40.22
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/** * The Class Band. */
@Entity
public class Band {

    @Id
    @GeneratedValue
    private int        id;

    // @JoinColumns({
    // @JoinColumn(name = "instrument_name", referencedColumnName = "name"),
    // @JoinColumn(name = "satellite_name", referencedColumnName =
    // "satellite_name")
    // })
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Instrument instrument;

    private double     lunghezzaOnda;

    private double     risoluzione;

    /** * Instantiates a new banda. */
    public Band() {}

    /**
     * * Instantiates a new banda. * * @param risoluzione the risoluzione
     * * @param lunghezzaOnda the lunghezza onda
     */
    public Band(double risoluzione, double lunghezzaOnda) {
        this.risoluzione = risoluzione;
        this.lunghezzaOnda = lunghezzaOnda;
    }

    public Band(double risoluzione, double lunghezzaOnda, Instrument instrument) {
        super();
        this.risoluzione = risoluzione;
        this.lunghezzaOnda = lunghezzaOnda;
        this.instrument = instrument;
    }

    /** * Gets the lunghezza onda. * * @return the lunghezza onda */
    public double getLunghezzaOnda() {
        return lunghezzaOnda;
    }

    /** * Gets the risoluzione. * * @return the risoluzione */
    public double getRisoluzione() {
        return risoluzione;
    }

    /** * Gets the instrument. * * @return the instrument */
    public Instrument getStrument() {
        return instrument;
    }

    /**
     * * Sets the lunghezza onda. * * @param lunghezzaOnda the new lunghezza
     * onda
     */
    public void setLunghezzaOnda(double lunghezzaOnda) {
        this.lunghezzaOnda = lunghezzaOnda;
    }

    /** * Sets the risoluzione. * * @param risoluzione the new risoluzione */
    public void setRisoluzione(double risoluzione) {
        this.risoluzione = risoluzione;
    }

    /** * Sets the instrument. * * @param instrument the new instrument */
    public void setStrument(Instrument instrument) {
        this.instrument = instrument;
    }
}