package c03_stacks_and_queues.p3_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 8/9/14.
 */
public class StackWithMinTest {
    StackWithMin stack;
    @Before
    public void setUp() {
        stack = new StackWithMin();
    }

    @Test(expected = EmptyStackException.class)
    public void testMinOfEmptyStack() {
        stack.min();
    }

    @Test
    public void testSuccess() {
        stack.push(5);
        assertEquals(5, stack.min());
        stack.push(6);
        assertEquals(5, stack.min());
        stack.push(3);
        assertEquals(3, stack.min());
        stack.push(7);
        assertEquals(3, stack.min());
        stack.pop();
        assertEquals(3, stack.min());
        stack.pop();
        assertEquals(5, stack.min());
    }

    @After
    public void tearDown() {
        stack = null;
    }
}
