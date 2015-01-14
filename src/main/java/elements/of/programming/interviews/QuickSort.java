package elements.of.programming.interviews;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by sharath on 1/7/15.
 */
public class QuickSort {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    public QuickSort() {
        numbers = new int[SIZE];
        Random generator = new Random();
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    public void sort() {
        sort(0, numbers.length - 1);
    }

    private void sort(int start, int end) {
        if(start < end) {
            int pivotIndex = partition(start, end);
            // partition puts the pivot element in the right place(element in the first position in this case)
            // then sort elements which are to the left and right separately
            sort(start, pivotIndex - 1);
            sort(pivotIndex + 1, end);
        }
    }

    private int partition(int left, int right) {
        int pivot = numbers[left];
        int i = left + 1;

        // j is the index at beginning of un-partitioned array
        // everything between i and j are partitioned(not exactly ordered)
        // partitioned means everything to the left of i is smaller than pivot and
        // everything to it's right till j is larger than the pivot
        for(int j = left + 1; j <= right; j++) {
            if(numbers[j] < pivot) {
                swap(i, j);
                i++;
            }
        }
        // at this point, left is the pivotIndex and i - 1 is the index where it should be when sorted
        swap(left, i - 1);
        return i - 1;
    }

    private void swap(int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        System.out.println(Arrays.toString(sorter.numbers));
        sorter.sort();
        for(int i = 0; i < sorter.numbers.length - 1; i++) {
            if(sorter.numbers[i] > sorter.numbers [i + 1]) {
                System.out.println("Should not happen");
            }
        }
        System.out.println(Arrays.toString(sorter.numbers));
    }
}