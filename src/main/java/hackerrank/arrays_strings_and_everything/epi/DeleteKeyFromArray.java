package hackerrank.arrays_strings_and_everything.epi;

import java.util.Arrays;
import java.util.List;

/**
 * Implement a remove function to remove a given key from a given array. It's okay to modify the array.
 * It doesn't matter what place holders are used for the cells that get emptied at the end.
 * Left shift the keys to fill the voids on remove.
 *
 * e.g : remove(3, [5,3,7,11,2,3,13,5,7]) should return
 * either [5,7,11,2,13,5,7] or [5,7,11,2,13,5,7,0,0] or
 * [5,7,11,2,13,5,7,5,7] -> doesn't matter what the last entries are, we could return next index to write to.
 *
 * Hint:
 * Don't remove one at a time. That will result in O(n^2) time complexity. Creating a new array requires O(n) space.
 * For every key you encounter, maintain a counter that says how many entries to skip while shifting left.
 *
 * Created by sharath on 10/31/15.
 */
public class DeleteKeyFromArray {
    public static int deleteKey(int key, List<Integer> A) {
        int writeIndex = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) != key) {
                A.set(writeIndex++, A.get(i));
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        Integer[] arr = {5,3,7,11,2,3,13,5,7};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        deleteKey(3, list);
        System.out.println(list);
    }
}
