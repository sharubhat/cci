package practicalunittesting;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sharath on 4/6/15.
 */
public class MockitoVerificationTest {
    private Car myFerrari = mock(Car.class);

    @Test
    public void testVerification() {
        myFerrari.driveTo("Sweet home in kumta");
        myFerrari.needsFuel();

        verify(myFerrari).driveTo("Sweet home in kumta");
        verify(myFerrari).needsFuel();
    }
}
