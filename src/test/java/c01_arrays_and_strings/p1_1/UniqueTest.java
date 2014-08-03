package c01_arrays_and_strings.p1_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueTest {
    private static Unique unique;

    @Before
    public void setUp() throws Exception {
        unique = new Unique();
    }

    @Test
    public void uniqueFalse() {
        assertFalse("Test with duplicate characters", unique.hasAllUniqueChars("Hello"));
    }

    @Test
    public void uniqueTrue() {
        assertTrue("Test all unique", unique.hasAllUniqueChars("zhdkgs"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void uniqueForNull() {
        unique.hasAllUniqueChars(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void uniqueForEmptyString() {
        unique.hasAllUniqueChars("");
    }

    @After
    public void tearDown() throws Exception {
        unique = null;
    }
}