package c09_recursion_and_dp.recursion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 8/16/14.
 */
public class TriangularNumbersTest {
    TriangularNumbers tn;
    @Before
    public void setUp() {
        tn = new TriangularNumbers();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNum() {
        tn.nthTNumber(-4);
    }

    @Test
    public void testPositiveNum() {
        assertEquals("nth number of triagle series", 21, tn.nthTNumber(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegNum() {
        tn.nthTNum(-4);
    }

    @Test
    public void testPosNum() {
        assertEquals("tail recursion - nth number of triagle series", 21, tn.nthTNum(6));
    }

    @After
    public void tearDown() {
        tn = null;
    }
}
