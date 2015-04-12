package practicalunittesting;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sharath on 4/6/15.
 */
public class MockitoThrowingExceptionsTest {
    private Car myFerrari = mock(Car.class);

    @Test(expected = RuntimeException.class)
    public void throwException() {
        when(myFerrari.needsFuel()).thenThrow(RuntimeException.class);
        myFerrari.needsFuel();
    }
}
