package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.AssertFalse;

public class AssertFalseTest extends AbstractTest {
    @Test
    public void testTrue() {
        final Object testedObject = new Object() {
            @AssertFalse
            public boolean flag = false;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testFalse() {
        final Object testedObject = new Object() {
            @AssertFalse
            public boolean flag = true;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNull() {
        final Object testedObject = new Object() {
            @AssertFalse
            public Boolean flag = null;
        };

        shouldPass(testedObject);
    }
}
