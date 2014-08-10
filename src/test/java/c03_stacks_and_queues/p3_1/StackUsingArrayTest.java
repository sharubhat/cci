package c03_stacks_and_queues.p3_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sharath on 8/8/14.
 */
public class StackUsingArrayTest {
    StackUsingArray stack;
    @Before
    public void setUp() {
        stack = new StackUsingArray(15);

    }

    @Test
    public void testPush() {
        assertEquals(1, stack.push(1, 1));
        assertEquals(2, stack.push(1, 2));
        assertEquals(1, stack.push(2, 1));
        assertEquals(2, stack.push(2, 2));
        assertEquals(1, stack.push(3, 1));
        assertEquals(2, stack.push(3, 2));
        assertEquals(3, stack.push(3, 3));
        assertEquals(4, stack.push(3, 4));
        assertEquals(5, stack.push(3, 5));
    }

    @Test(expected = StackOverflowError.class)
    public void testPushOverflow() {
        assertEquals(1, stack.push(3, 1));
        assertEquals(2, stack.push(3, 2));
        assertEquals(3, stack.push(3, 3));
        assertEquals(4, stack.push(3, 4));
        assertEquals(5, stack.push(3, 5));
        assertEquals(5, stack.size(3));
        stack.push(3, 6);
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() {
        stack.peek(2);
    }

    @Test
    public void testPeek() {
        stack.push(3, 1);
        stack.push(3, 2);
        assertEquals("Test peek in a non empty stack", 2, stack.peek(3));
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        stack.pop(2);
    }

    @Test
    public void testPop() {
        stack.push(2, 1);
        stack.push(2, 2);
        // [1, 2]
        assertEquals(2, stack.peek(2));
        stack.pop(2);
        // [1]
        assertEquals(1, stack.peek(2));
        stack.push(2, 4);
        // [1, 4]
        assertEquals(4, stack.peek(2));
        stack.pop(2);
        // [1]
        assertEquals(1, stack.peek(2));
    }

    @Test
    public void testEmpty() {
        assertTrue(stack.empty(1));
        stack.push(1, 5);
        assertFalse(stack.empty(1));
        stack.pop(1);
        assertTrue(stack.empty(1));
    }

    @After
    public void tearDown() {
        stack = null;
    }

}
