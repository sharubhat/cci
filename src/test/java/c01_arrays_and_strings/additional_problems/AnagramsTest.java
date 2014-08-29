package c01_arrays_and_strings.additional_problems;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sharath on 8/12/14.
 */
public class AnagramsTest {
    Anagrams a;

    @Before
    public void setUp() {
        a = new Anagrams();
    }

    @Test
    public void testEmptyString() {
        assertArrayEquals("Testing empty string", new String[]{""}, a.allAnagrams("").toArray());
    }

    @Test
    public void testAnagrams() {
        Set<String> results = new HashSet<>();
        results.add("cat");results.add("cta");
        results.add("act");results.add("atc");
        results.add("tca");results.add("tac");
        assertEquals("Testing cat", results, a.allAnagrams("cat"));
    }
}
