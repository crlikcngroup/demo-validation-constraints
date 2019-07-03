package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Pattern;

public class RepeatingAnnotationTest extends AbstractTest {
    /**
     * Multiple annotations of the same type can be used for an element.
     *
     * In older versions this was not possible, so special .List annotations were implemented
     * that could hold list of given annotations.
     *
     * All constraints must be satisfied to not generate an validation error.
     */
    @Test
    public void testMultipleList() {
        Object testedObject = new Object() {
            @Pattern.List({
                    @Pattern(regexp = "[A-Z]{3} \\d+", message = "Not currency"),
                    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Wrong symbols")
            })
            public String price = "EUR 250";
        };

        shouldPass(testedObject);
    }

    /**
     * Today, javax annotations has @Repeatable annotation themselves, so this notation
     * is also possible.
     */
    @Test
    public void testMultipleRepeatable() {
        Object testedObject = new Object() {
            @Pattern(regexp = "[A-Z]{3} \\d+", message = "Not currency")
            @Pattern(regexp = "[a-z0-9 ]+", message = "Wrong symbols")
            public String price = "EUR 250";
        };

        shouldFail(testedObject);
    }
}
