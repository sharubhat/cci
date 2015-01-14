package elements.of.programming.interviews;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 1/5/15.
 */
public class StringIntegerTest {
    private static StringInteger_5_1 stringInteger;

    @Before
    public void setUp() {
        stringInteger = new StringInteger_5_1();
    }

    @Test(expected = NumberFormatException.class)
    public void toIntNull() {
        stringInteger.stringToInt(null);
    }

    @Test(expected = NumberFormatException.class)
    public void toIntInvalidFirstChar() {
        stringInteger.stringToInt("a1234");
    }

    @Test(expected = NumberFormatException.class)
    public void toIntNotANumber() {
        stringInteger.stringToInt("123g7");
    }

    @Test
    public void toIntAPositiveNumber() {
        assertEquals("Convert a positive number", 12345, stringInteger.stringToInt("12345"));
    }

    @Test
    public void toIntANegativeNumber() {
        assertEquals("Convert a negative number", -12345, stringInteger.stringToInt("-12345"));
    }
}
