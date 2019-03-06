package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Negative;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NegativeTest extends AbstractTest {
    @Test
    public void testNegativeNumber() {
        Object testedObject = new Object() {
            @Negative
            public int num = -1000;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testZero() {
        Object testedObject = new Object() {
            @Negative
            public int num = 0;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testPositiveNumber() {
        Object testedObject = new Object() {
            @Negative
            public int num = 9999;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Negative
            public Integer num = null;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }
}
