package test;

import main.org.bdc.controls.C_UC_SearchSource;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.ClumpDetails;
import main.org.bdc.model.galaxy.Position;
import main.org.bdc.model.galaxy.Source;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestSourcesInArea {

    private Source source;

    public TestSourcesInArea(Source source) {
        this.source = source;
    }

    @Parameterized.Parameters
    public static Collection<Source> data() {

        Source source1 = new Source();
        source1.setId("G042.0014+00.7820");
        source1.setDistance(100);
        source1.setPosition(new Position(0.0, -42.0));

        Source source2 = new Source();
        source2.setId("G000.0014+42.7820");
        source2.setDistance(200);
        source2.setPosition(new Position(0.0, 42.0));

        return Arrays.asList(source1, source2);
    }

    @Test
    public void test() {

        String[] strings = null;

        try {
            strings = C_UC_SearchSource.getInstance().searchSourceInRegion(false, true, this.source.getPosition().getLatitude(),
                    this.source.getPosition().getLongitude(), this.source.getDistance(), 50);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull("Error", strings);

    }
}
