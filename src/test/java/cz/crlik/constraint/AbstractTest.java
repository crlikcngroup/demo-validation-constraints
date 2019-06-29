package cz.crlik.constraint;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractTest {
    /**
     * Creates validator instance.
     *
     * @return Validator instance.
     */
    protected final Validator createValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    /**
     * Validate object and assert that validation passed without errors.
     *
     * @param testedObject Object with validation annotations.
     */
    protected final void shouldPass(final Object testedObject) {
        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertTrue(violations.isEmpty());
    }

    /**
     * Validate object and assert that validation failed.
     *
     * @param testedObject Object with validation annotations.
     */
    protected final void shouldFail(final Object testedObject) {
        Validator validator = createValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(testedObject);

        assertFalse(violations.isEmpty());
    }
}
