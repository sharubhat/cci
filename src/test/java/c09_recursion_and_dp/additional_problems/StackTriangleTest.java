package c09_recursion_and_dp.additional_problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 8/21/14.
 */
public class StackTriangleTest {
    StackTriangle st;
    @Before
    public void setUp() {
        st = new StackTriangle();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNum() {
        st.nthNumber(-4);
    }

    @Test
    public void testPositiveNum() {
        assertEquals("nth number of triagle series", 21, st.nthNumber(6));
    }

    @After
    public void tearDown() {
        st = null;
    }
}
