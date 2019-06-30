package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

public class SizeTest extends AbstractTest {
    @Test
    public void testArrayIsTooSmall() {
        Object testedObject = new Object() {
            @Size(min=2, max=10)
            public int[] items = {1};
        };

        shouldFail(testedObject);
    }

    @Test
    public void testStringIsTooLong() {
        Object testedObject = new Object() {
            @Size(min=2, max=10)
            public String msg = "This is an urgent message!";
        };

        shouldFail(testedObject);
    }

    @Test
    public void testCollectionIsWithinBounds() {
        Object testedObject = new Object() {
            @Size(min=2, max=10)
            public List<Integer> items = Arrays.asList( 1, 2, 3, 4, 5);
        };

        shouldPass(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Size(min=2, max=10)
            public String msg = null;
        };

        shouldPass(testedObject);
    }
}
