package c02_Linked_List.p2_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 8/3/14.
 */
public class RemoveDupesTest {
    RemoveDupes r;
    @Before
    public void setUp() {
        r = new RemoveDupes();
    }

    @Ignore("Not ready to run")
    @Test
    public void removeDupes() {
        LinkedList list = new LinkedList(new int[]{5, 6, 3, 7, 4, 3, 0, 6, 1, 0});
        LinkedList result = new LinkedList(new int[]{5, 6, 3, 7, 4, 0, 1});
        r.removeDupes(list);
        assertEquals("Removing duplicates", result, list);
    }

    @After
    public void tearDown() {
        r = null;
    }
}
