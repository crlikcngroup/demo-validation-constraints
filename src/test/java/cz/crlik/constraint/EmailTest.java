package cz.crlik.constraint;

import org.junit.Test;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class EmailTest extends AbstractTest {
    @Test
    public void testValidEmail() {
        Object testedObject = new Object() {
            @Email
            public String email = "john@skynet.org";
        };

        shouldPass(testedObject);
    }

    @Test
    public void testInvalidEmail() {
        Object testedObject = new Object() {
            @Email
            public String email = "john@skynet@org";
        };

        shouldFail(testedObject);
    }

    /**
     * User can specify extra regex pattern for the email string.
     * She can force certain domain for the email address this way for example.
     *
     * Also regex option flags can be specified
     */
    @Test
    public void testExtraRegexpCondition() {
        Object testedObject = new Object() {
            @Email(regexp = ".*@gmail.com", flags = {Pattern.Flag.CASE_INSENSITIVE})
            public String email = "john@gmail.com";
        };

        shouldPass(testedObject);
    }

    @Test
    public void testEmptyString() {
        Object testedObject = new Object() {
            @Email
            public String email = "";
        };

        shouldPass(testedObject);
    }

    @Test
    public void testNull() {
        Object testedObject = new Object() {
            @Email
            public String email = null;
        };

        shouldPass(testedObject);
    }
}
