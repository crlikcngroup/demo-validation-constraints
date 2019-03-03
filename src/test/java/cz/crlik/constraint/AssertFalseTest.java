package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AssertFalseTest extends AbstractTest{
    @Test
    public void testTrue() {
        final Object testedObject = new Object() {
            @AssertFalse
            public boolean flag = false;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testFalse() {
        final Object testedObject = new Object() {
            @AssertFalse
            public boolean flag = true;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testNull() {
        final Object testedObject = new Object() {
            @AssertFalse
            public Boolean flag = null;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }
}
