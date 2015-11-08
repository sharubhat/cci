package hackerrank.arrays_strings_and_everything;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an input array find all sub arrays with given sum K
 *
 * Created by sharath on 11/7/15.
 */
public class SubArraySumK {



    private static boolean hasSumK(int[] IntArr, int iTarget) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        map.put(0, initial);
        int preSum = 0;

        for(int i=0; i< IntArr.length; i++) {
            preSum += IntArr[i];
            if(map.containsKey(preSum - iTarget)) {
                return true;
            }

            List<Integer> newStart = new ArrayList<>();
            if(map.containsKey(preSum)) {
                newStart = map.get(preSum);
            }
            newStart.add(i);
            map.put(preSum, newStart);
        }
        return false;
    }
}
