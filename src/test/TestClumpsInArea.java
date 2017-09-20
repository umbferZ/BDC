package test;

import main.org.bdc.controls.C_UC_SearchClumps;
import main.org.bdc.controls.C_UC_SearchSource;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.ClumpDetails;
import main.org.bdc.model.people.UserRegistered;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestClumpsInArea {

    private Clump clump;

    public TestClumpsInArea(Clump clump) {
        this.clump = clump;
    }

    @Parameterized.Parameters
    public static Collection<Clump> data() {

        Clump clumpInRound = new Clump();
        clumpInRound.setId(178136);
        clumpInRound.setDistance(1);
        ClumpDetails clumpDetails = new ClumpDetails();
        clumpDetails.setLat(0.0);
        clumpDetails.setLon(-42.0);
        clumpInRound.setClumpDetails(clumpDetails);

        Clump clumpNotInRound = new Clump();
        clumpNotInRound.setId(178971);
        clumpNotInRound.setDistance(200);
        ClumpDetails clumpDetails2 = new ClumpDetails();
        clumpDetails2.setLat(42.0);
        clumpDetails2.setLon(0.0);
        clumpNotInRound.setClumpDetails(clumpDetails2);

        Clump clumpInSquare = new Clump();
        clumpInSquare.setId(188134);
        clumpInSquare.setDistance(0.5);
        ClumpDetails clumpDetails3 = new ClumpDetails();
        clumpDetails3.setLat(0.0);
        clumpDetails3.setLon(-42.0);
        clumpInSquare.setClumpDetails(clumpDetails3);

        Clump clumpNotInSquare = new Clump();
        clumpNotInSquare.setId(176197);
        clumpNotInSquare.setDistance(3.5);
        ClumpDetails clumpDetails4 = new ClumpDetails();
        clumpDetails4.setLat(42.0);
        clumpDetails4.setLon(0.0);
        clumpInSquare.setClumpDetails(clumpDetails4);

        return Arrays.asList(clumpInRound, clumpNotInRound, clumpInSquare, clumpNotInSquare);
    }

    @Test
    public void test(){

        String[] strings = null;

        try {
            strings = C_UC_SearchSource.getInstance().searchSourceInRegion(true,false, this.clump.getClumpDetails().getLat(),
                    this.clump.getClumpDetails().getLon(), this.clump.getDistance(), 50);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull("Error", strings);

    }
}
