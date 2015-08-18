package hackerrank.recursion.classroom;

import java.util.Arrays;

/**
 * Print all permutations of given array.
 *
 * T(n) = O(n*n!)
 * S(n) = O(n)
 *
 * Created by sharath on 8/14/15.
 */
public class ArrayPermutations {

    private static void printPermR(int[] arr, int i) {
        if(i == arr.length)
            System.out.println(Arrays.toString(arr));

        for(int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            printPermR(arr, i + 1);
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printPerm(int[] arr) {
        printPermR(arr, 0);
    }

    public static void main(String[] args) {
        int in[] = {5, 3, 4};
        printPerm(in);
    }
}
