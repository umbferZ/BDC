/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.pk
 * Type: ClumpDetails_PK
 * Last update: 9-set-2017 13.15.43
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

public class ClumpDetails_PK implements Serializable {

    private int clump;

    public ClumpDetails_PK() {}

    public int getClump() {
        return clump;
    }

    public void setClump(int clump) {
        this.clump = clump;
    }

}
