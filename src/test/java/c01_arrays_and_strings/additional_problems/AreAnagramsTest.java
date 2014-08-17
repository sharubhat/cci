package c01_arrays_and_strings.additional_problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sharath on 8/12/14.
 */
public class AreAnagramsTest {
    AreAnagrams areAnagrams;

    @Before
    public void setUp() {
        areAnagrams = new AreAnagrams();
    }

    @Test
    public void testEmptyStrings() {
        assertFalse("Testing empty strings - areAnagrams",
                areAnagrams.areAnagrams("", ""));
        assertFalse("Testing empty strings - checkAnagrams",
                areAnagrams.checkAnagrams("", ""));
    }

    @Test
    public void testAnagrams() {
        assertTrue("Testing anagrams - areAnagrams",
                areAnagrams.areAnagrams("car", "rac"));
        assertTrue("Testing anagrams - checkAnagrams",
                areAnagrams.checkAnagrams("car", "rca"));
    }

    @Test
    public void testNonAnagrams() {
        assertFalse("Testing non-anagrams - areAnagrams",
                areAnagrams.areAnagrams("card", "rac"));
        assertFalse("Testing non-anagrams - checkAnagrams",
                areAnagrams.checkAnagrams("card", "rca"));
    }

    @After
    public void tearDown() {
        areAnagrams = null;
    }
}
