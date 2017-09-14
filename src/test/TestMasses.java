package test;

import main.org.bdc.controls.C_UC_SearchClumpsMass;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.ClumpDetails;
import main.org.bdc.model.galaxy.Flow;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sasha on 13/09/17.
 */

/*
@RunWith(value = Parameterized.class)
public class TestMasses {

    private ClumpDetails clump;

    public TestMasses(ClumpDetails clump) {
        this.clump = clump;
    }

    @Parameterized.Parameters
    public static List<Serializable> data() {
        ClumpDetails correctClump = new ClumpDetails();
        correctClump.setTemperatura(13.40f);
        correctClump.getClump().addFlow(new Flow(16.39f));

        ClumpDetails missingTempClump = new ClumpDetails();
        missingTempClump.getClump().addFlow(new Flow(16.39f));

        ClumpDetails missingFlowClump = new ClumpDetails();
        missingFlowClump.setTemperatura(13.40f);

        Clump blankClump = new Clump();
        return Arrays.asList(
                correctClump,
                missingFlowClump,
                missingTempClump
        );
    }

    @Test
    public void testMasses(){
        double mass = C_UC_SearchClumpsMass.getInstance().searchClumpsMass();
        Assert.assertEquals("Wrong!", 0.053 * this.clump.getClump().getFlows().get(0) * 100 * Math.exp(41.14 / this.clump.getTemperatura() - 1), mass);
    }

    @Test
    public void testAvgMasses(){
        double avg = C_UC_SearchClumpsMass.getInstance().showClumpsAvgMass();
        Assert.assertEquals("Wrong!", , avg);
    }

    @Test
    public void testMidMasses(){
        double mid = C_UC_SearchClumpsMass.getInstance().searchClumpsMass();
        Assert.assertEquals("Wrong!", 0.053 * this.clump.getClump().getFlows().get(0) * 100 * Math.exp(41.14 / this.clump.getTemperatura() - 1), mid);
    }

    @Test
    public void testDevMasses(){
        double dev = C_UC_SearchClumpsMass.getInstance().searchClumpsMass();
        Assert.assertEquals("Wrong!", 0.053 * this.clump.getClump().getFlows().get(0) * 100 * Math.exp(41.14 / this.clump.getTemperatura() - 1), dev);
    }

    @Test
    public void testMidDevMasses(){
        double middev = C_UC_SearchClumpsMass.getInstance().searchClumpsMass();
        Assert.assertEquals("Wrong!", 0.053 * this.clump.getClump().getFlows().get(0) * 100 * Math.exp(41.14 / this.clump.getTemperatura() - 1), middev);
    }

}
*/