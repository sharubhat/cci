package c02_Linked_List.p2_7;

import c02_Linked_List.LinkedList.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sharath on 8/7/14.
 */
public class PalindromeTest {
    Palindrome palindrome;
    @Before
    public void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    public void testEmptyList() {
        assertTrue("Test with empty list",
                palindrome.isPalindrome(new LinkedList()));
    }

    @Test
    public void testPalindromeEvenCount() {
        assertTrue("Test a list with even number of nodes",
                palindrome.isPalindrome(new LinkedList(new int[]{1, 2, 3, 3, 2, 1})));
    }

    @Test
    public void testPalindromeOddCount() {
        assertTrue("Test a list with odd number of nodes",
                palindrome.isPalindrome(new LinkedList(new int[]{1, 2, 3, 2, 1})));
    }

    @Test
    public void testNotPalindrome() {
        assertFalse("Test a list that is not a palindrome",
                palindrome.isPalindrome(new LinkedList(new int[]{1, 2, 3, 3, 2})));
    }

    @After
    public void tearDown(){
        palindrome = null;
    }
}
