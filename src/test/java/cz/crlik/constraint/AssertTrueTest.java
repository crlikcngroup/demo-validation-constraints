package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.AssertTrue;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AssertTrueTest extends AbstractTest {
    @Test
    public void testTrue() {
        final Object testedObject = new Object() {
            @AssertTrue
            public boolean flag = true;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void failedTest() {
        assertFalse(true);
        
    }

    @Test
    public void testFalse() {
        final Object testedObject = new Object() {
            @AssertTrue
            public boolean flag = false;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testNull() {
        final Object testedObject = new Object() {
            @AssertTrue
            public Boolean flag = null;
        };

        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }
}
