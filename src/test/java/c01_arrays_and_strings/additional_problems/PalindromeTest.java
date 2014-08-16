package c01_arrays_and_strings.additional_problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sharath on 8/12/14.
 *
 * Check if a given string is palindrome
 */
public class PalindromeTest {
    Palindrome p;
    @Before
    public void setUp() {
        p = new Palindrome();
    }

    @Test
    public void testStrLengthLessThan2() {
        assertFalse("Empty string", p.isPalindrome(""));
        assertFalse("String with lenght less than 2", p.isPalindrome("a"));
    }

    @Test
    public void testNonPalindrome(){
        assertFalse("A non palindrome string", p.isPalindrome("goal"));
    }

    @Test
    public void testPalindromeString(){
        assertTrue("A string that is palindrome", p.isPalindrome("cattac"));
    }

    @After
    public void tearDown() {
        p = null;
    }
}
