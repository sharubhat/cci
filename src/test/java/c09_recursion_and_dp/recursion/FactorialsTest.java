package c09_recursion_and_dp.recursion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 8/16/14.
 */
public class FactorialsTest {
    Factorials fact;
    @Before
    public void setUp() {
        fact = new Factorials();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNum() {
        fact.fact(-4);
    }

    @Test
    public void testPositiveNum() {
        assertEquals("nth number of triagle series", 362_880, fact.fact(9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegNum() {
        fact.factTR(-4);
    }

    @Test
    public void testPosNum() {
        assertEquals("tail recursion - nth number of triagle series", 362_880, fact.factTR(9));
    }

    @After
    public void tearDown() {
        fact = null;
    }
}
