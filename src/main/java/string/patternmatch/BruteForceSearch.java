package string.patternmatch;

/**
 * Created by sharath on 10/24/14.
 */
public class BruteForceSearch {
    private char[] text;
    private char[] pattern;
    private int n;
    private int m;

    public void setString(String t, String p) {
        this.text = t.toCharArray();
        this.pattern = p.toCharArray();
        this.n = t.length();
        this.m = p.length();
    }

    public int search() {
        for(int i = 0; i < n - m; i++) {
            int j = 0;
            while(j < m && text[i + j] == pattern[j]) {
                j++;
            }
            if(j == m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        BruteForceSearch bfs = new BruteForceSearch();
        String text = "Lorem ipsum dolor sit amet";
        String pattern = "ipsum";

        bfs.setString(text, pattern);
        int firstOccurPos = bfs.search();
        System.out.println("The text '" + pattern + "' is first found after the " + firstOccurPos + " position.");
    }
}
