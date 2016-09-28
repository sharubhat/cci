package hackerrank.recursion.cci;

/**
 * Magic index in an array is an index where the element in the index is same as index.
 * Write a function that checks if the given array has magic index.
 *
 * Brute force is to check every element. O(n) time complexity.
 * Binary search approach can reduce the complexity to O(logn). If middle element is smaller than middle index,
 * then check only right half and vice versa.
 *
 * Created by sharath on 8/16/15.
 */
public class MagicIndex {
    public static void main(String[] args) {
        int[] in = {-40,-20,-1,1,2,3,5,7,9,12,13};
        System.out.println(magicSlow(in));
        System.out.println(magicFast(in));
    }

    public static int magicSlow(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int magicFast(int[] arr) {
        return magicFastR(arr, 0, arr.length - 1);
    }

    public static int magicFastR(int[] arr, int start, int end) {
        if(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == mid)
                return mid;
            if(arr[mid] < mid)
                return magicFastR(arr, mid + 1, end);
            return magicFastR(arr, start, mid - 1);
        }
        return -1;
    }
}
