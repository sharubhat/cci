package hackerrank.sorting_test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * What is a heap?
 *
 * A binary heap is a data structure which is designed to ensure
 * the minimum element can always be accessed in constant time and removed in lg(n) time.
 * Elements can also be added in lg(n) time.
 * It works by using a backing array (or array list in this case) and treating it like a tree.
 * We can calculate the left child of index (n) by doing (2n + 1), and the right child with (2n + 2).
 * The parent of any node is ((n-1)/2).
 * This will make sense if you draw out a binary tree and label the nodes left-to-right, row-by-row 0, 1, 2, 3, etc.
 * You will see the node left of 0 is 1 (2*0 + 1). The node left of 1 is 3 (2*1 + 1),
 * and the node right of 1 is 4 (2*1 + 2), etc.
 *
 * How does it work?
 *
 * The min-heap property states that every that is a child of N must be greater than or equal to N.
 * This is does not ensure we have a binary-search-tree.
 * For example, 57 may be the left child of 5 and 6 may be the right child of 5.
 * This is fine as both nodes are still greater than N = 5.
 * To add elements to the heap we put the new element at the end of the array and 'bubble-it-up',
 * swapping it with its parent until it is less than both of its children. Keep in mind,
 * it may start in the right place.
 * To remove elements from the heap, we take out the root (guaranteed to be the minimum value),
 * place the last element in the heap at the root, and then bubble the root down to its appropriate position.
 * While bubbling-down, the element is always swapped with its minimum child
 * to ensure the element swapped up is still less than both of its children.
 *
 * Created by sharath on 8/6/15.
 */
public class PriorityQueue {
    private List<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    //Define functions for determining the parent, left, and right
    //node from any given node.
    private int parentIndex(int n) {
        return n == 0 ? -1 : (n - 1) >>> 1;
    }

    private int leftChildIndex(int n) {
        return 2 * n + 1;
    }

    private int rightChildIndex(int n) {
        return 2 * n + 2;
    }

    private int minChildIndex(int n) {
        int lChildIndex = leftChildIndex(n);
        int rChildIndex = rightChildIndex(n);
        if(lChildIndex > heap.size() - 1)
            return -1;
        if(rChildIndex > heap.size() - 1)
            return leftChildIndex(n);
        return (heap.get(lChildIndex) <= heap.get(rChildIndex)) ? lChildIndex : rChildIndex;
    }

    public int size() { return heap.size(); }

    public void add(int e) {
        heap.add(e);
        bubbleUp();
    }

    public int remove() {
        if(size() == 0)
            throw new NoSuchElementException("Empty heap");
        if(size() == 1)
            return heap.remove(0);

        int result = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        bubbleDown();
        return result;
    }

    private void bubbleUp() {
        int index = size() - 1;
        int parentIndex = parentIndex(index);
        while(index > 0 && heap.get(parentIndex) > heap.get(index)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parentIndex(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        int minChildIndex = minChildIndex(index);
        while(minChildIndex != -1 && heap.get(minChildIndex) < heap.get(index)) {
            swap(minChildIndex, index);
            index = minChildIndex;
            minChildIndex = minChildIndex(index);
        }
    }

    private void swap(int i1, int i2) {
        int tmp = heap.get(i1);
        heap.set(i1, heap.get(i2));
        heap.set(i2, tmp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    //Assert the current structure is a heap.
    public boolean isHeap() {
        for (int i = 1; i < size(); ++i) {
            if (parentIndex(i) >= 0) {
                if (heap.get(parentIndex(i)) > heap.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PriorityQueue h = new PriorityQueue();
        Random random = new Random();
        for (int i = 0; i < 10; ++i)
            h.add(random.nextInt(100) + 1);

        System.out.println(h.toString());

        //Assert that it is a valid heap of the proper size.
        if(!h.isHeap())
            System.out.println(("Not a proper heap!" +  h.isHeap()));

        //Remove all elements from the heap ensuring they come out in minimum sorted order.
        int lastRemoved = -1;
        while (h.size() > 0) {

            //Remove the smallest element from the top of the heap.
            int removed = h.remove();

            System.out.println("Removed: " + removed);

            //Ensure the next item we removed is bigger than the last so we know that the heap
            //is working properly and ensure the resulting structure is still a heap.
            if(!(lastRemoved <= removed))
                System.out.println("Ordering broken during removal." + (lastRemoved <= removed));
            if(!h.isHeap())
                System.out.println("It's no longer a heap " + h.isHeap());

            //Save the last removed element and move on.
            lastRemoved = removed;
        }
    }
}
