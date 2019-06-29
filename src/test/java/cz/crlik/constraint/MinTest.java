package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Min;

public class MinTest extends AbstractTest {
    @Test
    public void testBelowMinimum() {
        Object testedObject = new Object() {
            @Min(100)
            public int num = 1;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testEqualsMinimum() {
        Object testedObject = new Object() {
            @Min(100)
            public int num = 100;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testAboveMinimum() {
        Object testedObject = new Object() {
            @Min(100)
            public int num = 144;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Min(100)
            public Integer num = null;
        };

        shouldPass(testedObject);
    }
}
