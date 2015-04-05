package practicalunittesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sharath on 4/4/15.
 */
public class ClientTest {

    private Address addressA = new Address("Street A");
    private Address addressB = new Address("Street B");
    private Client client;

    @Before
    public void setUp() {
        client = new Client();
    }

    @Test
    public void afterCreationShouldHaveNoAddress() {
        assertEquals(0, client.getAddresses().size());
    }

    @Test
    public void shouldAllowToAddAddresses() {
        client.addAddress(addressA);

        assertEquals(1, client.getAddresses().size());
        assertTrue(client.getAddresses().contains(addressA));
    }

    @Test
    public void shouldAllowToAddMultipleAddresses() {
        client.addAddress(addressA);
        client.addAddress(addressB);

        assertEquals(2, client.getAddresses().size());
        assertTrue(client.getAddresses().contains(addressA));
        assertTrue(client.getAddresses().contains(addressB));
    }

}
