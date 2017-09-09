
/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: ClumpType
 * Last update: 9-set-2017 12.51.21
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