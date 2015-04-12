package practicalunittesting;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sharath on 4/6/15.
 */
public class FirstMockitoTest {

    private Car myFerrari = mock(Car.class);

    @Test
    public void testIfCarIsFerrarri() {
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void testDefaultBehaviorOfTestDouble() {
        assertFalse("new test double should return false as boolean",
                myFerrari.needsFuel());

        when(myFerrari.needsFuel()).thenReturn(true);

        assertTrue("after instructed test double should return what we want ", myFerrari.needsFuel());
    }
}
