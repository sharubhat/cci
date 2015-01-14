package elements.of.programming.interviews;

import java.util.Arrays;

public class DutchFlagPartition_6_1 {
    public static int[] rearrange(int[] A, int i) {
        int pivot = A[i];
        int smaller = 0, curr = 0, larger = A.length - 1;
        while(curr <= larger) {
            // A[curr] is the incoming unclassified element
            if(A[curr] < pivot) {
                // if smaller goes to left, ignore it by incrementing smaller
                // It's important to increment the current. Why? Because it's being swapped with smaller element that
                // has already been classified once. No need to position it again.
                swap(A, smaller++, curr++);
            }
            else if(A[curr] == pivot) {
                ++curr;
            }
            else if(A[curr] > pivot){
                // if larger gets swapped to end, ignore it by decrementing larger
                // It's important not to increment the current. Why? Because it's an unclassified element that has
                // not been positioned correctly yet
                swap(A, curr, larger--);
            }
        }
        return A;
    }
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 5, 2, 6, 1, 9, 3, 3};
        new DutchFlagPartition_6_1().rearrange(A, 7);
        System.out.println(Arrays.toString(A));
    }
}
