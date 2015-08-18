package hackerrank.sorting_test;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 8/6/15.
 */
public class PriorityQueueTest {

    @Test
    public void arrayListHeapTest() {

        //Create a heap of a thousand random elements.
        PriorityQueue h = new PriorityQueue();
        Random random = new Random();
        for (int i = 0; i < 1000; ++i) h.add(random.nextInt(1000) + 1);

        //Assert that it is a valid heap of the proper size.
        assertTrue("Not a proper heap!", h.isHeap());
        assertEquals(h.size(), 1000);

        //Remove all elements from the heap ensuring they come out in minimum sorted order.
        int lastRemoved = -1;
        while (h.size() > 0) {

            //Remove the smallest element from the top of the heap.
            int removed = h.remove();

            //Print out every 100th element we remove just for some comforting output.
            if (h.size() % 100 == 0) {
                System.out.println("Removed: " + removed);
            }

            //Ensure the next item we removed is bigger than the last so we know that the heap
            //is working properly and ensure the resulting structure is still a heap.
            assertTrue("Ordering broken during removal.", lastRemoved <= removed);
            assertTrue(h.isHeap());

            //Save the last removed element and move on.
            lastRemoved = removed;
        }
    }
}
