package string.word_ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sharath on 3/22/15.
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start==null||end==null||dict==null||start.length()==0||start.length()!=end.length()){
            throw new IllegalArgumentException("Invalid inputs");
        }

        Queue<String> qToOffer = new LinkedList<>();
        Queue<String> qToPoll = new LinkedList<>();

        int i = 0;

        qToPoll.offer(start);
        while(!qToPoll.isEmpty() || !qToOffer.isEmpty()) {
            String current = qToPoll.poll();
            char[] sChars = current.toCharArray();

            for(int j = 0; j < sChars.length; j++) {
                char original = sChars[j];

                for (char c = 'a'; c < 'z'; c++) {
                    if (c == sChars[j]) {
                        continue;
                    }

                    sChars[j] = c;
                    String tmp = new String(sChars);

                    if(tmp.equals(end)) {
                        return i + 1;
                    }

                    if(dict.contains(tmp)) {
                        qToOffer.offer(tmp);
                        dict.remove(tmp);
                    }
                }
                sChars[j] = original;
            }
            i++;
            Queue<String> tmpQ = qToPoll;
            qToPoll = qToOffer;
            qToOffer = tmpQ;
        }
        return 0;
    }


    public static void main(String[] args) {
        Set<String> input = new HashSet<>();
        input.add("hot");
        input.add("dot");
        input.add("dog");
        input.add("lot");
        input.add("log");

        System.out.println(new Solution().ladderLength("hit", "cog", input));

        Set<String> input2 = new HashSet<>();
        input.add("a");
        input.add("b");
        input.add("c");

        System.out.println(new Solution().ladderLength("a", "c", input2));
    }
}
