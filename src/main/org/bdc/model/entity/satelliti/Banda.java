/*
 *
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.entity.satelliti
 * Type: Banda
 * Last update: 12-mar-2017 16.11.09
 *
 */

package main.org.bdc.model.entity.satelliti;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import main.org.bdc.model.entity.satelliti.pk.Banda_PK;

/** * The Class Banda. */
@Entity
@IdClass(Banda_PK.class)
public class Banda {

    @Id
    private double lunghezzaOnda;

    @Id
    private double risoluzione;

    @Id
    @JoinColumns({ @JoinColumn(name = "strumento_nome", referencedColumnName = "nome"), @JoinColumn(name = "satellite_nome", referencedColumnName = "satellite_nome") })
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Strumento strumento;

    /** * Instantiates a new banda. */
    public Banda() {}

    /**
     * * Instantiates a new banda. * * @param risoluzione the risoluzione
     * * @param lunghezzaOnda the lunghezza onda
     */
    public Banda(double risoluzione, double lunghezzaOnda) {
        this.risoluzione = risoluzione;
        this.lunghezzaOnda = lunghezzaOnda;
    }

    /** * Gets the lunghezza onda. * * @return the lunghezza onda */
    public double getLunghezzaOnda() {
        return lunghezzaOnda;
    }

    /** * Gets the risoluzione. * * @return the risoluzione */
    public double getRisoluzione() {
        return risoluzione;
    }

    /** * Gets the strumento. * * @return the strumento */
    public Strumento getStrumento() {
        return strumento;
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

    /** * Sets the strumento. * * @param strumento the new strumento */
    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }
}