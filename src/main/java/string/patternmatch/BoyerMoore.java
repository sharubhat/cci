package string.patternmatch;

/**
 * Created by sharath on 10/25/14.
 */
public class BoyerMoore {
    private final int BASE = 256;
    private int[] occurrance;
    private String pat;

    public BoyerMoore(String pattern) {
        this.pat = pattern;
        this.occurrance = new int[BASE];
        for(int i = 0; i < occurrance.length; i++)
            occurrance[i] = -1;
        for(int j = 0; j < pat.length(); j++)
            occurrance[pat.charAt(j)] = j;
    }

    private int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int skip;
        for(int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for(int j = M - 1; j >= 0; j--) {
                if(pat.charAt(j) != txt.charAt(i+j)) {
                    skip = Math.max(1, j - occurrance[txt.charAt(i+j)]);
                    break;
                }
            }
            if(skip == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String pat = "needle";
        String txt = "Finding needle in a haystack";

        BoyerMoore boyermoore = new BoyerMoore(pat);
        int offset1 = boyermoore.search(txt);

        // print results
        System.out.println("text:    " + txt);

        System.out.println("pattern: " + pat);

        System.out.println("Found at index " + offset1);


    }
}
