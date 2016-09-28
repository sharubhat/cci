package hackerrank.sorting_test;

import java.util.Arrays;
import java.util.List;

/**
 * Median of unsorted array of odd length is the middle element when it's sorted, and in case of even length
 * array, it's either of the two middle elements.
 *
 * Hint: No need to sort, use quick select until the pivot gets placed in the center.
 * The algorithm has O(n^2) worst case and O(n) average case complexity.
 *
 * Created by sharath on 1/3/16.
 */
public class MedianUnsortedArray {
    public int select(List<Integer> list) {
        return select(list, 0, list.size() - 1, list.size()/2);
    }

    private int select(List<Integer> list, int start, int end, int k) {
        if(start == end)
            return list.get(start);
        int pivotIndex = partition(list, start, end);
        if(pivotIndex == k)
            return list.get(pivotIndex);
        else if(pivotIndex < k)
            return select(list, pivotIndex+1, end, k);
        else
            return select(list, start, pivotIndex - 1, k);
    }

    private int partition(List<Integer> list, int left, int right) {
        int pivot = list.get(left);
        int k = left;
        for(int i = left + 1; i <= right; i++) {
            if(list.get(i) < pivot) {
                swap(list, ++k, i);
            }
        }
        swap(list, left, k);
        return k;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3,6,8,1,9,4,7,2};
        System.out.println(new MedianUnsortedArray().select(Arrays.asList(nums)));
    }
}
