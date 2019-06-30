package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;

public class NotEmptyTest extends AbstractTest {
    @Test
    public void testEmptyString() {
        Object testedObject = new Object() {
            @NotEmpty
            public String msg = "";
        };

        shouldFail(testedObject);
    }

    @Test
    public void testStringWithBlankChars() {
        Object testedObject = new Object() {
            @NotEmpty
            public String msg = "  ";
        };

        shouldPass(testedObject);
    }

    @Test
    public void testNullString() {
        Object testedObject = new Object() {
            @NotEmpty
            public String msg = null;
        };

        shouldFail(testedObject);
    }

    /**
     * On Raw Type collections it does not work for some reason.
     *
     * So having just Collection items = Collections.emptyList();
     * results in exception: "No validator could be found for constraint ..."
     * or similar.
     */
    @Test
    public void testEmptyCollection() {
        Object testedObject = new Object() {
            @NotEmpty
            public Collection<Integer> items = Collections.emptyList();
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNonEmptyCollection() {
        Object testedObject = new Object() {
            @NotEmpty
            public Collection<Integer> items = Collections.singletonList(5);
        };

        shouldPass(testedObject);
    }

    @Test
    public void testEmptyArray() {
        Object testedObject = new Object() {
            @NotEmpty
            public Integer[] items = {};
        };

        shouldFail(testedObject);
    }

    @Test
    public void testNonEmptyArray() {
        Object testedObject = new Object() {
            @NotEmpty
            public Integer[] items = {1, 2};
        };

        shouldPass(testedObject);
    }
}
