package hackerrank.sorting_test;

import java.util.*;

/**
 * Given an array of K strings length N each,
 * return all groups of strings that are anagrams. (Assume all lower case input)
 *
 * Hint: Aim for O(KNlogN) time complexity and O(KN) space complexity.
 *
 * For better clarity : an example group of words that are anagrams could be,
 * google, ooggle, ogogle, ggoole
 *
 * P.S.: String length begin N doesn't offer any advantage.
 *
 * Created by sharath on 8/7/15.
 */
public class GroupAnagrams {
    public static void main(String[] args) throws Exception {
//        SecureRandom random = new SecureRandom();
//
//        int k  = random.nextInt(10);
//        int n = random.nextInt(10);
//
//        String[] input = new String[k];
//
//        for(int i = 0; i < k; i++) {
//            input[i] = nextString(random, n);
//        }
//
//        String[] input1 = {"Cable", "able", "baCle", "googe"};
//
//        Map<String, Set<String>> result= group(input1);
//
//        for(Map.Entry e : result.entrySet()) {
//            System.out.println(e.getKey() + " " + e.getValue());
//        }

        System.out.println("Enter the strings in the array as comma separated values");
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        String[] input = in.split(",");

        List<Set<String>> result= group(input);

        for(Set<String> s : result) {
            System.out.println(s);
        }
    }

    static List<Set<String>> group(String[] input) {
        Map<String, Set<String>> store = new HashMap<>();
        for(String s : input) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!store.containsKey(key)) {
                Set<String> value = new HashSet<>();
                value.add(s);
                store.put(key, value);
            } else {
                store.get(key).add(s);
            }
        }

        List<Set<String>> result = new ArrayList<>();

        for(Map.Entry e : store.entrySet()) {
            Set<String> value = (Set<String>)e.getValue();
            if(value.size() > 1) {
                result.add(value);
            }
        }

        return result;
    }

    private static String nextString(Random random, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) random.nextInt(256);
            sb.append(c);
        }
        return sb.toString();
    }
}
