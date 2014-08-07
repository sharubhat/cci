package c02_Linked_List.p2_6;

import c02_Linked_List.LinkedList.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sharath on 8/6/14.
 */
public class LoopInListTest {
    LoopInList loopInList;

    @Before
    public void setUp(){
        loopInList = new LoopInList();
    }

    @Test
    public void checkLoopInEmptyList() {
        assertFalse("Checking for loop in empty list",
                loopInList.hasLoop(new LinkedList()));
    }

    @Test
    public void checkLoopInListWithLoop(){
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4, 5, 6});
        list.head.next.next.next.next.next.next = list.head.next.next.next;
        assertTrue("Checking for loop in a list with loop",
                loopInList.hasLoop(list));
    }

    @Test
    public void checkLoopInListWithoutLoop(){
        assertFalse("Checking for loop in list with no loop",
                loopInList.hasLoop(new LinkedList(new int[]{1, 2, 3, 4, 5, 6})));
    }

    @After
    public void tearDown(){
        loopInList = null;
    }
}
