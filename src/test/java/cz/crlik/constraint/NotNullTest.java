package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NotNullTest extends AbstractTest {
    @Test
    public void testWhenNull() {
        final Object testedObject = new Object() {
            @NotNull
            public Integer counter = null;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testWhenNotNull() {
        final Object testedObject = new Object() {
            @NotNull
            public Integer counter = new Integer(100);
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }
}
