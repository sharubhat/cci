package practicalunittesting.phone;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sharath on 4/10/15.
 */
public class ClientTestUsingTestDoubles {
    private static final Phone MOBILE_PHONE = mock(Phone.class);
    private static final Phone LAND_LINE = mock(Phone.class);

    Client client = new Client();

    @Test
    public void shouldReturnTrueIfClientHasMobile() {
        when(MOBILE_PHONE.isMobile()).thenReturn(true);

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
