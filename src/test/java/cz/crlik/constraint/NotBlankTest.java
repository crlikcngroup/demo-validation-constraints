package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.NotBlank;

public class NotBlankTest extends AbstractTest {
    @Test
    public void testValidString() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "my_name";

        };

        shouldPass(testedObject);
    }

    @Test
    public void testString_withLeadingAndTrailingSpaces() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "  my_name   ";

        };

        shouldPass(testedObject);
    }

    @Test
    public void testEmptyString() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "";

        };

        shouldFail(testedObject);
    }

    @Test
    public void testStringWithOnlyWhiteSpaces() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "  \t ";

        };

        shouldFail(testedObject);
    }

    @Test
    public void testStringIsNull() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = null;

        };

        shouldFail(testedObject);
    }
}
