package practicalunittesting.exercise;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 4/4/15.
 */
@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {
    private StringReverse stringReverse;
    @Before
    public void setUp() {
        stringReverse = new StringReverse();
    }

    private static Object[] getValidStrings() {
        return $($("a"), $("word"), $("two words"));
    }

    @Test
    @Parameters(method = "getValidStrings")
    public void reverseShouldReturnReversedStringForValidInput(String validStrings) {
        String result = new StringBuilder(validStrings).reverse().toString();
        assertEquals(result, stringReverse.reverse(validStrings));
    }

    private static Object[] getInvalidStrings() {
        return new String[][]{{""}, {null}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidStrings")
    public void reverseShouldThrowIAEForInvalidInput(String invalidStrings) {
        stringReverse.reverse(invalidStrings);
    }
}
