package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Pattern;

public class PatternTest extends AbstractTest {
    @Test
    public void testValidPattern() {
        Object testedObject = new Object() {
            @Pattern(regexp = "[A-Z]{3} \\d+")
            public String price = "USD 250";
        };

        shouldPass(testedObject);
    }

    @Test
    public void testValidPattern_caseInsensitive() {
        Object testedObject = new Object() {
            @Pattern(regexp = "[A-Z]{3} \\d+", flags = Pattern.Flag.CASE_INSENSITIVE)
            public String price = "eur 250";
        };

        shouldPass(testedObject);
    }

    @Test
    public void testInvalidPattern() {
        Object testedObject = new Object() {
            @Pattern(regexp = "[A-Z]{3} \\d+")
            public String price = "250 euros";
        };

        shouldFail(testedObject);
    }
}
