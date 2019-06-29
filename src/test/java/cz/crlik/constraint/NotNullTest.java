package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.NotNull;

public class NotNullTest extends AbstractTest {
    @Test
    public void testWhenNull() {
        final Object testedObject = new Object() {
            @NotNull
            public Integer counter = null;
        };

        shouldFail(testedObject);
    }

    @Test
    public void testWhenNotNull() {
        final Object testedObject = new Object() {
            @NotNull
            public Integer counter = new Integer(100);
        };

        shouldPass(testedObject);
    }
}
