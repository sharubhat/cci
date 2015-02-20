package string.patternmatch;

/**
 * Created by sharath on 10/24/14.
 * O(n + m) running time
 *
 * Refer DS and Algo in Java by Goodrich and Tamassia
 *
 * The main idea of the KMP algorithm is to pre-compute self-overlaps
 * between portions of the pattern so that when a mismatch occurs at one location,
 * we immediately know the maximum amount to shift the pattern before continuing the search.
 */
public class KnuthMorrisPratt {

    public static int findKMP(char[] text, char[] pat) {
        int n = text.length;
        int m = pat.length;
        if(m == 0) return 0;                // empty string search
        int[] fail = computeFailKMP(pat);   // computing the fail
        int j = 0;                          // index to text
        int k = 0;                          // index to pat
        while(j < n) {
            if(text[j] == pat[k]) {         // pat[0..k] is matched so far
                if(k == m - 1)              // match complete
                    return j - m + 1;
                j++;                        // match not complete, try to extend match
                k++;
            } else if(k > 0) {
                k = fail[k - 1];            // reuse suffix of P[0..k-1]
            } else {
                j++;
            }
        }
        return -1;                          // reached the end without any match
    }

    /*
    Constructing the KMP Failure Function
    To construct the failure function, we use the same method,
    which is a “bootstrapping” process that compares the pattern to itself as in the KMP algorithm.
    Each time we have two characters that match, we set f ( j) = k + 1.
    Note that since we have j > k throughout the execution of the algorithm,
    f (k − 1) is always well defined when we need to use it.
     */
    private static int[] computeFailKMP(char[] pat) {
        int m = pat.length;
        int[] fail = new int[m];
        int j = 1;
        int k = 0;
        while(j < m) {              // compute fail[j] during this pass
            if(pat[j] == pat[k]) {
                fail[j] = k + 1;
                j++;
                k++;
            }
            else if(k > 0) {        // k follows a matching prefix
                k = fail[k - 1];
            } else {
                j++;                // no match found starting at j
            }
        }
        return fail;
    }

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet";
        String pattern = "ipsum";

        int first_occur_position = findKMP(text.toCharArray(), pattern.toCharArray());
        System.out.println("The text '" + pattern + "' is first found on the "
                + first_occur_position + " position.");
    }
}
