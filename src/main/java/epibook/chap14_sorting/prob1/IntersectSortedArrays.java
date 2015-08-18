package epibook.chap14_sorting.prob1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sharath on 6/29/15.
 */
public class IntersectSortedArrays {
    public static void main(String[] args) {
        Integer[] a1 = {2,3,3,5,5,6,7,7,8,12};
        Integer[] b1 = {5,5,6,8,8,9,10,10};
        List<Integer> a = Arrays.asList(a1);
        List<Integer> b = Arrays.asList(b1);
        System.out.println(a);
        System.out.println(b);
        List<Integer> r1 = IntersectSortedArrays1.intersectTwoSortedArrays(a, b);
        System.out.println(r1);
        List<Integer> r2 = IntersectSortedArrays2.intersectTwoSortedArrays(a, b);
        System.out.println(r2);
        List<Integer> r3 = IntersectSortedArrays3.intersectTwoSortedArrays(a, b);
        System.out.println(r3);
    }
}
