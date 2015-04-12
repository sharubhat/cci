package practicalunittesting.exercise;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Created by sharath on 4/5/15.
 */
@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

    private static PasswordValidator validator = new PasswordValidator();
    private static final String ALL_LOWER_CASE_PWD = "abc1";
    private static final String NO_DIGIT_PWD = "Abc";

    private static final String VALID_PASSWORD = "Abc1";

    private static Object[] getInvalidStrings() {
        return new String[][]{{""}, {null}};
    }

    @Test(expected = InvalidPasswordException.class)
    @Parameters(method = "getInvalidStrings")
    public void shouldThrowIAEForInvalidStrings(String invalidStrings) {
        validator.validate(invalidStrings);
    }

    @Test(expected = InvalidPasswordException.class)
    public void shouldThrowExceptionIfPasswordDoesNotContainAtLeastOneUpperCaseCharacter() {
        validator.validate(ALL_LOWER_CASE_PWD);
    }

    @Test(expected = InvalidPasswordException.class)
    public void shouldThrowExceptionIfPasswordDoesNotContainAtLeastADigit() {
        validator.validate(NO_DIGIT_PWD);
    }

    @Ignore
    @Test
    public void passwordWithAtLeastOneUpperCaseAndOneDigitShouldBeValid() {
        assertTrue(validator.validate(VALID_PASSWORD));
    }
}
