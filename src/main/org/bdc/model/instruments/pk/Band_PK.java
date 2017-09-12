/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.instruments.pk
 * Type: Band_PK
 * Last update: 13-set-2017 0.27.24
 * 
 */

package main.org.bdc.model.instruments.pk;

import java.io.Serializable;

/**
 * The Class Band_PK.
 */
public class Band_PK implements Serializable {

    // @JoinColumn(name = "instrument_id")
    protected int    instrument;

    protected double resolution;

    /**
     * Instantiates a new band PK.
     */
    public Band_PK() {}

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    public int getInstrument() {
        return this.instrument;
    }

    public double getResolution() {
        return this.resolution;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

}