package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.PositiveOrZero;

public class PositiveOrZeroTest extends AbstractTest {
    @Test
    public void testPositiveNumber() {
        Object testedObject = new Object() {
            @PositiveOrZero
            public int num = 9999;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testZero() {
        Object testedObject = new Object() {
            @PositiveOrZero
            public int num = 0;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testNegativeNumber() {
        Object testedObject = new Object() {
            @PositiveOrZero
            public int num = -1000;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @PositiveOrZero
            public Integer num = null;
        };

        shouldPass(testedObject);
    }
}
