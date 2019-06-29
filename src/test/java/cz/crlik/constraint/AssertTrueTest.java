package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.AssertTrue;

public class AssertTrueTest extends AbstractTest {
    @Test
    public void testTrue() {
        final Object testedObject = new Object() {
            @AssertTrue
            public boolean flag = true;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testFalse() {
        final Object testedObject = new Object() {
            @AssertTrue
            public boolean flag = false;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNull() {
        final Object testedObject = new Object() {
            @AssertTrue
            public Boolean flag = null;
        };

        shouldPass(testedObject);
    }
}
