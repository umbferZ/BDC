package test;

import main.org.bdc.controls.C_UC_SearchClumpsDensity;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.ClumpDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Sasha on 13/09/17.
 */

@RunWith(value = Parameterized.class)
public class TestSearchClumpsDensity {

    public TestSearchClumpsDensity(Clump clump) {
        this.clump = clump;
    }

    private Clump clump;

    @Parameterized.Parameters
    public static Collection<Clump> data() {



        return Arrays.asList(

        );
    }

    @Test
    public void test() {

    }
}

