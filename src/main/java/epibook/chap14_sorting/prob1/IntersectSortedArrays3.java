package epibook.chap14_sorting.prob1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 6/29/15.
 */
public class IntersectSortedArrays3 {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> a, List<Integer> b) {
        int i = 0, j = 0;
        List<Integer> intersect = new ArrayList<>();

        while(i < a.size() && j < b.size()) {
            if(a.get(i) == b.get(j) && (i == 0 || a.get(i) != a.get(i - 1))) {
                intersect.add(a.get(i));
                i++;
                j++;
            } else if(a.get(i) < b.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return intersect;
    }
}
