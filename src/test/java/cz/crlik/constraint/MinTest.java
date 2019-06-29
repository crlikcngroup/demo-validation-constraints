package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MinTest extends AbstractTest {
    @Test
    public void testBelowMinimum() {
        Object testedObject = new Object() {
            @Min(100)
            public int num = 1;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testEqualsMinimum() {
        Object testedObject = new Object() {
            @Min(100)
            public int num = 100;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testAboveMinimum() {
        Object testedObject = new Object() {
            @Min(100)
            public int num = 144;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Min(100)
            public Integer num = null;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }
}
