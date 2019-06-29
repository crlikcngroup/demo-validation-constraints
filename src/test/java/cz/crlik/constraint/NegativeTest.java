package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Negative;

public class NegativeTest extends AbstractTest {
    @Test
    public void testNegativeNumber() {
        Object testedObject = new Object() {
            @Negative
            public int num = -1000;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testZero() {
        Object testedObject = new Object() {
            @Negative
            public int num = 0;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testPositiveNumber() {
        Object testedObject = new Object() {
            @Negative
            public int num = 9999;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Negative
            public Integer num = null;
        };

        shouldPass(testedObject);
    }
}
