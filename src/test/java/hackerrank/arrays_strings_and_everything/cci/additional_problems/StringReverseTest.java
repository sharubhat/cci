package hackerrank.arrays_strings_and_everything.cci.additional_problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 8/29/14.
 */
public class StringReverseTest {
    StringReverse sr;
    @Before
    public void setUp() {
        sr = new StringReverse();
    }

    @Test
    public void testReverse() {
        assertEquals("Testing builder", "etarak", sr.usingBuilder("karate"));
        assertEquals("Testing iterative", "etarak", sr.iterative("karate"));
        assertEquals("Testing recursive", "etarak", sr.recursive("karate"));
    }

    @After
    public void tearDown(){
        sr = null;
    }
}
