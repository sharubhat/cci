package hackerrank.sorting_test;

import java.util.Arrays;

/**
 * Created by sharath on 8/5/15.
 */
public class QuickSort {
    public void sort(int[] in) {
        sort(in, 0, in.length - 1);
    }

    // Quick sort is simple.
    // Take a pivot element, place it such that everything to it's left is lesser than the pivot
    // and everything to it is larger.
    // Sort the left sub-array and right sub-array
    private void sort(int[] in, int start, int end) {
        if(start < end) {
            // This step is an optimization. We are trying to make a best guess to divide the array almost equally.
            // i.e. Instead of simply choosing the first element as pivot, we find the median and swap it with first.
            // This reduces the risk of worst case being O(n2) when the data is already sorted.
            // Quick sort works perfectly fine when choosePivotAndSwapItToStart is not called.
            choosePivotAndSwapItToStart(in, start, end);
            int pivotIndex = partitionAndReturnPivotIndex(in, start, end);
            sort(in, start, pivotIndex - 1);
            sort(in, pivotIndex + 1, end);
        }
    }

    // finds median element in the array between start and end
    // swaps the median element with start so that first element of sub-array can be chosen as pivot.
    // This step is to ensure we have better chance at splitting the array into half to get O(nlogn).
    private void choosePivotAndSwapItToStart(int[] in, int start, int end) {
        int mid = start + (end - start) / 2;
        int a = in[start];
        int b = in[mid];
        int c = in[end];

        if((a <= b && b <= c) || (a >= b && b >= c)) {
            swap(in, start, mid);
        } else if((a <= c && c <= b) || (a >= c && c >= b)) {
            swap(in, start, end);
        }
    }

    // places pivot in the right position by moving all elements lesser to the left sub-array and
    // all elements greater to the right sub-array.
    private int partitionAndReturnPivotIndex(int[] in, int start, int end) {
        int pivot = in[start];
        int begin = start + 1; // begin at element to right of pivot(or element at start)

        // Now find the rank of pivot by placing all elements smaller than pivot to left.
        // (begin - 1) indicates the position where the pivot should be placed.
        for(int i = begin; i <= end; i++) {
            if(in[i] < pivot) {
                swap(in, begin, i);
                begin++;
            }
        }

        // Now that everything to right of pivot element is correctly partitioned,
        // it's time to place the pivot in it's rightful position.
        // Note that begin is now pointing to an element larger than pivot,
        // and (begin - 1) is smaller than pivot. So (begin - 1) is the correct spot to place pivot.
        swap(in, start, begin - 1);

        // return the position of pivot
        return begin - 1;
    }

    private void swap(int[] in, int i1, int i2) {
        int tmp = in[i1];
        in[i1] = in[i2];
        in[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] a1 = {};
        int[] a2 = {-5,-4,-3,-2,-1,0,1,2,3,4,5,6};
        int[] a3 = {6,3,9,2,7,4,6,3};
        int[] a4 = {6,5,4,3,2,1};

        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(a1));
        qs.sort(a1);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        qs.sort(a2);
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        qs.sort(a3);
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a4));
        qs.sort(a4);
        System.out.println(Arrays.toString(a4));
    }

}
