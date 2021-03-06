package corejavainterviewquestions;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sharath on 3/15/15.
 */
public class QueueTest {
    private Queue queue;
    @Before
    public void setUp() {
        this.queue = new Queue();
    }

    // Queue has two methods which should be tested : add and remove. Stack has push and pop.
    @Test
    public void addingOneItemAndRemovingFromQueueWillReturnThatItem() throws Exception {

        queue.add("Item 1");

        assertThat(queue.remove(), is("Item 1"));
    }

    @Test
    public void addingMultipleItemsThenRemovingOneItemWillReturnFirstItem() throws Exception {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        assertThat(queue.remove(), is("Item 1"));
    }

    @Test
    public void addingThreeItemsRemovingTwoWillReturnItemOneThenTwo() throws Exception {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        assertThat(queue.remove(), is("Item 1"));
        assertThat(queue.remove(), is("Item 2"));
    }

    @Test
    public void multipleAddsAndRemovesInCorrectOrder() throws Exception {
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        assertThat(queue.remove(), is("Item 1"));
        queue.add("Item 4");
        queue.add("Item 5");
        assertThat(queue.remove(), is("Item 2"));

        queue.add("Item 6");
        assertThat(queue.remove(), is("Item 3"));
        assertThat(queue.remove(), is("Item 4"));
    }
}
