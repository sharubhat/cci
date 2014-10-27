package c01_arrays_and_strings.additional_problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 8/12/14.
 */
public class FindFirstNonRepeatedCharTest {
    FindFirstNonRepeatedChar ffnr;
    @Before
    public void setUp() {
        ffnr = new FindFirstNonRepeatedChar();
    }

    @Test
    public void testEmptyString() {
        assertEquals("Testing empty strings",
                '\0',
                ffnr.firstNonRepeatedChar(""));
    }

    @Test
    public void testAllUnique() {
        assertEquals("Testing strings with all unique chars",
                'g',
                ffnr.firstNonRepeatedChar("golden"));
    }

    @Test
    public void testStringWithDupes() {
        assertEquals("Testing strings with duplicate chars",
                'e',
                ffnr.firstNonRepeatedChar("racccear"));
    }

    @After
    public void tearDown() {
        ffnr = null;
    }
}
