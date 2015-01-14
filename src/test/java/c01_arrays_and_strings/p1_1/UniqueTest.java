package c01_arrays_and_strings.p1_1;

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
    }

    @Test
    public void uniqueTrue() {
        assertTrue("Test all unique", unique.hasAllUniqueChars("zhdkgs"));
        assertTrue("Test all unique", unique.hasAllUniqueCharsUsingSet("zhdkgs"));
    }

    @Test
    public void uniqueForNull() {
        assertFalse("Test for null string", unique.hasAllUniqueChars(null));
        assertFalse("Test for null string", unique.hasAllUniqueCharsUsingSet(null));
    }

    @Test
    public void uniqueForEmptyString() {
        assertFalse("Test for empty string", unique.hasAllUniqueChars(""));
        assertFalse("Test for empty string", unique.hasAllUniqueCharsUsingSet(""));
    }

    @After
    public void tearDown() throws Exception {
        unique = null;
    }
}