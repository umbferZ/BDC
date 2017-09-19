package test;

import main.org.bdc.controls.C_UC_SearchSource;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Source;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestSearchInMIPSGAL {

    private Source source;

    public TestSearchInMIPSGAL(Source source) {
        this.source = source;
    }

    @Parameterized.Parameters
    public static Collection<Source> data() {

        Source source1 = new Source();
        source1.setMap(new Map("MIPSGAL-GAL"));

        Source source2 = new Source();
        source2.setMap(new Map("GLIMPSE"));

        return Arrays.asList(source1, source2);
    }

    @Test
    public void test() {

        String[] strings = null;

        try {
            strings = C_UC_SearchSource.getInstance().searchSourceInMipsGal(178110, 250);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull("Error", strings);

    }
}
