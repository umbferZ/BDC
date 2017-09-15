/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test
 * Type: TestSearchClump
 * Last update: 15-set-2017 11.49.54
 * 
 */

package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.org.bdc.controls.C_UC_SearchClumps;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.service.dal.exception.SaveDalException;

/**
 * Created by Sasha on 13/09/17.
 */
@RunWith(value = Parameterized.class)
public class TestSearchClump {

    private Clump clump;

    @Parameterized.Parameters
    public static Collection<Clump> data() {

        Clump clumpInDB = new Clump();
        clumpInDB.setId(179761);
        clumpInDB.setMap(new Map("GLIPSE"));

        Clump clumpNotInDB = new Clump();
        clumpNotInDB.setId(985);
        clumpNotInDB.setMap(new Map("MIPSGAL"));

        return Arrays.asList(clumpInDB, clumpNotInDB);
    }

    public TestSearchClump(Clump clump) {
        this.clump = clump;
    }

    @Test
    public void test() {
        Clump clump = null;
        try {
            clump = C_UC_SearchClumps.getInstance().searchClumps(this.clump.getId());
        } catch (SaveDalException e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull(clump);

    }
}
