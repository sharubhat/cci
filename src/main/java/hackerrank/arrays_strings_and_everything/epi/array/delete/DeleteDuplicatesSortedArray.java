package hackerrank.arrays_strings_and_everything.epi.array.delete;

import java.util.Arrays;
import java.util.List;

/**
 * Implement a remove function to delete duplicates from a sorted array. It's okay to modify the array.
 * It doesn't matter what place holders are used for the cells that get emptied at the end.
 * Left shift the keys to fill the voids on remove.
 *
 * e.g : removeDupes([2,3,5,5,7,11,11,11,13]) should return
 * either [2,3,5,7,11,13] or [2,3,5,7,11,13,0,0,0] or
 * [2,3,5,7,11,13,11,11,13] -> doesn't matter what the last entries are, we could return next index to write to.
 *
 * Created by sharath on 10/31/15.
 */
public class DeleteDuplicatesSortedArray {
    public static int removeDupes(List<Integer> A) {
        if(A.isEmpty())
            return 0;
        int writeIndex = 1;
        for(int i = 1; i < A.size(); i++) {
            if(!A.get(writeIndex - 1).equals(A.get(i))) {
                A.set(writeIndex++, A.get(i));
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        Integer[] arr = {2,3,5,5,7,11,11,11,13};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        removeDupes(list);
        System.out.println(list);
    }
}


