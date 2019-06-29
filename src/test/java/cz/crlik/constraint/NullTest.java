package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Null;

public class NullTest extends AbstractTest {
    @Test
    public void testWhenNull() {
        final Object testedObject = new Object() {
            @Null
            public Integer counter = null;
        };

        shouldPass(testedObject);
    }

    @Test
    public void testWhenNotNull() {
        final Object testedObject = new Object() {
            @Null
            public Integer counter = new Integer(100);
        };

        shouldFail(testedObject);
    }
}
