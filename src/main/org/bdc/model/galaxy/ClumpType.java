
/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: ClumpType
 * Last update: 13-set-2017 0.26.51
 * 
 */

package main.org.bdc.model.galaxy;

/**
 * The Enum ClumpType.
 */
public enum ClumpType {
    PreStellare(0), ProtoStellare(1), Sconosciuto(2);

    private int code;

    /**
     * Instantiates a new clump type.
     *
     * @param code the code
     */
    ClumpType(int code) {
        this.code = code;
    }
}