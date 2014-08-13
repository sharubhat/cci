package c01_arrays_and_strings.additional_problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sharath on 8/12/14.
 */
public class AnagramsTest {
    Anagrams anagrams;

    @Before
    public void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    public void testEmptyStrings() {
        assertFalse("Testing empty strings - areAnagrams",
                anagrams.areAnagrams("", ""));
        assertFalse("Testing empty strings - checkAnagrams",
                anagrams.checkAnagrams("", ""));
    }

    @Test
    public void testAnagrams() {
        assertTrue("Testing anagrams - areAnagrams",
                anagrams.areAnagrams("car", "rac"));
        assertTrue("Testing anagrams - checkAnagrams",
                anagrams.checkAnagrams("car", "rca"));
    }

    @Test
    public void testNonAnagrams() {
        assertFalse("Testing non-anagrams - areAnagrams",
                anagrams.areAnagrams("card", "rac"));
        assertFalse("Testing non-anagrams - checkAnagrams",
                anagrams.checkAnagrams("card", "rca"));
    }

    @After
    public void tearDown() {
        anagrams = null;
    }
}
