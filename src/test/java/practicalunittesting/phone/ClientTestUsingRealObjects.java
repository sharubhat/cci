package practicalunittesting.phone;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sharath on 4/10/15.
 */
public class ClientTestUsingRealObjects {

//    private static final String ANY_NUMBER = "999-888-7777";
//    private static final Phone MOBILE_PHONE = new Phone(ANY_NUMBER, true);
//    private static final Phone LAND_LINE = new Phone(ANY_NUMBER, false);

    private static final Phone MOBILE_PHONE = new Phone("+123456789");
    private static final Phone LAND_LINE = new Phone("123456789");

    Client client = new Client();

    // if client has no phone, hasMobile() returns false
    // if client has only land lines, hasMobile() returns false
    // if client has one or more mobile phones, hasMobile() returns true
    @Test
    public void shouldReturnTrueIfClientHasMobile() {
        client.addPhone(MOBILE_PHONE);
        client.addPhone(LAND_LINE);

        assertTrue(client.hasMobile());
    }

    @Test
    public void shouldReturnFalseIfClientHasNoMobile() {
        client.addPhone(LAND_LINE);

        assertFalse(client.hasMobile());
    }
}