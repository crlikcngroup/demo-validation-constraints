package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.NegativeOrZero;

public class NegativeOrZeroTest extends AbstractTest {
    @Test
    public void testNegativeNumber() {
        Object testedObject = new Object() {
            @NegativeOrZero
            public int num = -1000;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testZero() {
        Object testedObject = new Object() {
            @NegativeOrZero
            public int num = 0;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testPositiveNumber() {
        Object testedObject = new Object() {
            @NegativeOrZero
            public int num = 9999;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @NegativeOrZero
            public Integer num = null;
        };

        shouldPass(testedObject);
    }
}
