package practicalunittesting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static junitparams.JUnitParamsRunner.$;

import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 4/4/15.
 */
@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    private static final Object[] getMoney() {
        return $(
                $(10, "USD"),
                $(20, "EUR")
        );
    }

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }
}
