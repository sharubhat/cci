package hackerrank.arrays_strings_and_everything.epi.array.sort;

import java.util.*;

/**
 * Write a program that takes and array A and a pivot index i, such that all the elements less than A[i] appear
 * before followed by all A[i]'s followed by all the elements that are greater than A[i]
 *
 * Note: The problem is not to sort. The problem is only to divide the array such that
 * all the elements to it's left are smaller and all the elements to it's right are larger.
 * The elements to left and right themselves may be randomly arranged.
 *
 * E.g:
 * [-3,0,-1,1,1,1,?,?,?,4,2] and pivot = 1;
 *          s     e     l
 *
 * ? at e is compared with pivot, there are 3 possibilities.
 * 1. ? < e, swap elements at s and e and advance both s and e
 * 2. ? > e, swap elements at e and --l(don't advance e as the new element that gets placed in e is not evaluated yet)
 * 3. ? == e, advance e
 *
 * Sub-array between s and e will be an array with all elements equal to pivot.
 *
 * Created by sharath on 10/29/15.
 */
public class DutchFlag {
    public enum Color {RED, GREEN, BLUE}

    public static void dutchFlagPartition(final List<Color> A, final int pivotIndex) {
        Color pivot = A.get(pivotIndex);
        System.out.println(pivot);
        int smaller = 0, equal = 0, larger = A.size();
        while(equal < larger) {
            // A.get(equal) is the first unclassified element
            if(A.get(equal).ordinal() < pivot.ordinal())
                Collections.swap(A, smaller++, equal++);
            else if(A.get(equal).ordinal() > pivot.ordinal())
                Collections.swap(A, equal, --larger);
            else
                equal++;
        }
    }

    /**
     * Arrange such that each color is grouped, order of the entries doesn't matter.
     * Check if there is a better way than using left, right and center although they are done in O(n) time.
     *
     * @param A
     * @param pivotIndex
     */
    public static void dutchFlagGroupedSubArrays(final List<Color> A, final int pivotIndex) {
        Color pivot = A.get(pivotIndex);
        int center = pivot.ordinal();
        int left, right;
        if(center == 0) {
            left = 1;
            right = 2;
        } else if(center == 1) {
            left = 0;
            right = 2;
        } else {
            left = 0;
            right = 1;
        }
        System.out.println(pivot);
        int smaller = 0, equal = 0, larger = A.size();
        while(equal < larger) {
            if(A.get(equal).ordinal() == left)
                Collections.swap(A, smaller++, equal++);
            else if(A.get(equal).ordinal() == right)
                Collections.swap(A, equal, --larger);
            else
                equal++;
        }
    }

    public static void main(String[] args) {
        Color[] colors1 = {Color.RED, Color.BLUE, Color.BLUE, Color.RED, Color.GREEN, Color.GREEN,
                Color.GREEN, Color.BLUE, Color.RED, Color.RED, Color.BLUE, Color.GREEN};
        List<Color> list = Arrays.asList(colors1);
        dutchFlagGroupedSubArrays(list, 0);
        System.out.println(list);

        Color[] colors2 = {Color.RED, Color.BLUE, Color.BLUE, Color.RED, Color.GREEN, Color.GREEN,
                Color.GREEN, Color.BLUE, Color.RED, Color.RED, Color.BLUE, Color.GREEN};
        list = Arrays.asList(colors2);
        dutchFlagGroupedSubArrays(list, 1);
        System.out.println(list);

        Color[] colors3 = {Color.RED, Color.BLUE, Color.BLUE, Color.RED, Color.GREEN, Color.GREEN,
                Color.GREEN, Color.BLUE, Color.RED, Color.RED, Color.BLUE, Color.GREEN};
        list = Arrays.asList(colors3);
        dutchFlagGroupedSubArrays(list, list.size() - 1);
        System.out.println(list);
    }
}
