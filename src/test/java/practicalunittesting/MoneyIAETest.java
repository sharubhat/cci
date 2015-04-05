package practicalunittesting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static junitparams.JUnitParamsRunner.$;

/**
 * Created by sharath on 4/4/15.
 */
@RunWith(JUnitParamsRunner.class)
public class MoneyIAETest {
    // MoneyIAETest short for MoneyIllegalArgumentExceptionTest

    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";

    private static final Object[] getInvalidAmount() {
        return $($(-12387), $(-5), $(-1));

        // alternatively you could write, but $ is more cleaner way
        // return new Integer[][]{{-12387}, {-5}, {-1}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters("getInvalidAmount")
    public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
        new Money(invalidAmount, VALID_CURRENCY);
    }

    // Note: Can't use $ method here as $ does not accept null or empty values.
    private static Object[] getInvalidCurrency() {
        return new String[][]{{null}, {""}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
        Money money = new Money(VALID_AMOUNT, invalidCurrency);
    }
}
