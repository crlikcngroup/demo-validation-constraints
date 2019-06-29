package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Max;

public class MaxTest extends AbstractTest {
    @Test
    public void testBelowMaximum() {
        Object testedObject = new Object() {
            @Max(100)
            public int num = 1;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testEqualsMaximum() {
        Object testedObject = new Object() {
            @Max(100)
            public int num = 100;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testAboveMaximum() {
        Object testedObject = new Object() {
            @Max(100)
            public int num = 144;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Max(100)
            public Integer num = null;
        };

        shouldPass(testedObject);
    }
}
