package test;
/*
import main.org.bdc.controls.C_UC_SearchClumps;
import main.org.bdc.controls.C_UC_SearchClumpsDensity;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
*/
/**
 * Created by Sasha on 13/09/17.
 */
/*
@RunWith(value = Parameterized.class)
public class TestSearchClump {

    public TestSearchClump(Clump clump){
        this.clump = clump;
    }

    private Clump clump;

    @Parameterized.Parameters
    public static Collection<Clump> data() {

        Clump clumpInDB = new Clump();
        clumpInDB.setId(179761);
        clumpInDB.setMap(new Map("GLIPSE"));

        Clump clumpNotInDB = new Clump();
        clumpNotInDB.setId(985);
        clumpNotInDB.setMap(new Map("MIPSGAL"));

        return Arrays.asList(
                clumpInDB,
                clumpNotInDB
        );
    }

    @Test
    public void test() {
        /*C_UC_SearchClumps.getInstance().searchClumps(this.clump.getId());
        Assert.assertEquals("Error!", "GLIPSE", this.clump.getMap().getName());
        Assert.assertEquals("Not in DB", 179761, this.clump.getId());


    }
}
*/