package hackerrank.arrays_strings_and_everything.cci.p1_3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sharath on 8/2/14.
 */
public class CheckPermutationTest {
    private CheckPermutation checkPermutation;
    @Before
    public void setUp() {
        checkPermutation = new CheckPermutation();
    }

    @Test
    public void checkSuccess() {
        assertTrue("Check permute strings", checkPermutation.isPermuteCharArrayCompare("myname", "namemy"));
        assertTrue("Check permute strings", checkPermutation.isPermuteASCII("myname", "namemy"));
    }

    @Test
    public void checkFailure() {
        assertFalse("Check non permutes", checkPermutation.isPermuteCharArrayCompare("myname", "namemyy"));
        assertFalse("Check non permutes", checkPermutation.isPermuteASCII("myname", "namemyy"));
    }

    @Test
    public void checkNullInput() {
        assertFalse("Check for null input ", checkPermutation.isPermuteCharArrayCompare(null, null));
        assertFalse("Check for null input ", checkPermutation.isPermuteCharArrayCompare(null, "Hi There"));
        assertFalse("Check for null input ", checkPermutation.isPermuteCharArrayCompare("Hi There", null));
        assertFalse("Check for null input ", checkPermutation.isPermuteASCII(null, null));
        assertFalse("Check for null input ", checkPermutation.isPermuteASCII(null, "Hi There"));
        assertFalse("Check for null input ", checkPermutation.isPermuteASCII("Hi There", null));
    }

    @Test
    public void checkVariedLenght() {
        assertFalse("Check for strings of different length ", checkPermutation.isPermuteASCII("Hi There", "One"));
        assertFalse("Check for strings of different length ", checkPermutation.isPermuteCharArrayCompare("Hi There", "One"));
    }

    @After
    public void tearDown() {
        checkPermutation = null;
    }
}
