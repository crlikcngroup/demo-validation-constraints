package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NotBlankTest extends AbstractTest {
    @Test
    public void testValidString() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "my_name";

        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testString_withLeadingAndTrailingSpaces() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "  my_name   ";

        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testEmptyString() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "";

        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }
    @Test
    public void testStringWithOnlyWhiteSpaces() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = "  \t ";

        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testStringIsNull() {
        Object testedObject = new Object() {
            @NotBlank
            public String name = null;

        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }
}
