package c01_arrays_and_strings.additional_problems;

/**
 * Created by sharath on 8/28/14.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SumContiguousSubArrayTest {
    SumContiguousSubArray sum;
    @Before
    public void setUp() {
        sum = new SumContiguousSubArray();
    }

    @Test
    public void testKadaneSum() {
        assertEquals("For input {-1, 2, 3, -3, 4} ", 6, sum.KadaneSum(new int[]{-1, 2, 3, -3, 4}));
        assertEquals("For input {-6,2,-3,-4,-1,-5,-5} ", 2, sum.KadaneSum(new int[]{-6,2,-3,-4,-1,-5,-5}));
        assertEquals("For input {1,2,-1,2} ", 4, sum.KadaneSum(new int[]{1,2,-1,2}));
        assertEquals("For input {1,2,-2,1} ", 3, sum.KadaneSum(new int[]{1,2,-2,1}));
        assertEquals("For input {-1,-2,-2,-1} ", -1, sum.KadaneSum(new int[]{-1,-2,-2,-1}));
        assertEquals("For input {0,-1,-2,-2,-1} ", 0, sum.KadaneSum(new int[]{0,-1,-2,-2,-1}));
    }

    @After
    public void tearDown() {
        sum = null;
    }
}
