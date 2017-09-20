/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.instruments.pk
 * Type: Band_PK
 * Last update: 20-set-2017 13.23.24
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

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    /**
     * Gets the instrument.
     *
     * @return the instrument
     */
    public int getInstrument() {
        return this.instrument;
    }

    /**
     * Gets the resolution.
     *
     * @return the resolution
     */
    public double getResolution() {
        return this.resolution;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    /**
     * Sets the instrument.
     *
     * @param instrument the new instrument
     */
    public void setInstrument(int instrument) {
        this.instrument = instrument;
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