package hackerrank.arrays_strings_and_everything.cci.p1_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class UniqueTest {
    private static Unique unique;

    @Before
    public void setUp() throws Exception {
        unique = new Unique();
    }

    @Test
    public void uniqueFalse() {
        assertFalse("Test with duplicate characters", unique.hasAllUniqueChars("Hello"));
        assertFalse("Test with duplicate characters", unique.hasAllUniqueCharsUsingSet("Hello"));
        assertFalse("Test with duplicate characters", unique.isUniqueChars("hello"));
    }

    @Test
    public void uniqueTrue() {
        assertTrue("Test all unique", unique.hasAllUniqueChars("zhdkgs"));
        assertTrue("Test all unique", unique.hasAllUniqueCharsUsingSet("zhdkgs"));
        assertTrue("Test all unique", unique.isUniqueChars("zhdkgs"));
    }

    @Test
    public void uniqueForNull() {
        assertFalse("Test for null string", unique.hasAllUniqueChars(null));
        assertFalse("Test for null string", unique.hasAllUniqueCharsUsingSet(null));
        assertFalse("Test for null string", unique.isUniqueChars(null));
    }

    @Test
    public void uniqueForEmptyString() {
        assertFalse("Test for empty string", unique.hasAllUniqueChars(""));
        assertFalse("Test for empty string", unique.hasAllUniqueCharsUsingSet(""));
        assertFalse("Test for empty string", unique.isUniqueChars(""));
    }

    @After
    public void tearDown() throws Exception {
        unique = null;
    }
}