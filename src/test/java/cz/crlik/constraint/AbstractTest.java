package cz.crlik.constraint;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
}
