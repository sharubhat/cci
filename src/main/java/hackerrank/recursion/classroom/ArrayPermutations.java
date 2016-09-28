package hackerrank.recursion.classroom;

import java.util.Arrays;

/**
 * Print all permutations of given array.
 *
 * T(n) = O(n*n!) -> there are n! leaves in the tree and each leaf is of size n.
 *                       program can not run faster than the size of the output.
 * S(n) = O(n)  -> height of the tree.
 *
 * Hint: Look at n-queens problem to understand time complexity and recursion tree.
 *
 * Created by sharath on 8/14/15.
 */
public class ArrayPermutations {

    private static void printPermR(int[] arr, int i) {
        if(i == arr.length)
            System.out.println(Arrays.toString(arr));

        for(int j = i; j < arr.length; j++) {
            // allow arr[i] to be placed at every index and permute the rest.
            // or you could say, give every element(a[j]) a chance to be the first element and permute the rest.
            swap(arr, i, j);
            printPermR(arr, i + 1);
            // reset the array back to original state before giving arr[j+1] it's chance.
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
