package practicalunittesting.phone_excpetion;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


/**
 * Created by sharath on 4/11/15.
 */
public class PhoneTest {
    Phone phone = new Phone();

    @Test
    public void shouldThrowIAEForEmptyNumber() {
        catchException(phone).setNumber(null);

        assertThat(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("number can not be empty or null");

        // the below code is what you would usually write if you are not aware of FEST Fluent Assertion library
//        assertTrue(caughtException() instanceof IllegalArgumentException);
//        assertEquals("number can not be empty or null", caughtException().getMessage());


        // without catchException library, we would have to handle exception in ugly way
//        try {
//            phone.setNumber(null);
//            fail("Should hae thrown IllegalArgumentException");
//        } catch (Exception e) {
//            assertEquals("number can not be empty or null", e.getMessage());
//        }
    }

    @Test
    public void shouldThrowIAEForPlusPrefixedNumber() {
        catchException(phone).setNumber("+123");

        assertTrue(caughtException() instanceof IllegalArgumentException);
        assertEquals("plus sign prefix not allowed, number: [+123]", caughtException().getMessage());

//        try {
//            phone.setNumber("+123");
//        } catch (Exception e) {
//            assertEquals("plus sign prefix not allowed, number: [+123]", e.getMessage());
//        }
    }
}