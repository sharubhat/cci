package string.patternmatch;

/**
 * Created by sharath on 10/24/14.
 */
public class BruteForceSearch {

    public int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for(int i = 0; i < n - m; i++) {        // i is index for text and j is index for the pattern
            for(int j = 0; j < m && text.charAt(i + j) == pattern.charAt(j); j++) {
                if(j == m - 1)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet";
        String pattern = "ipsum";

        BruteForceSearch bfs = new BruteForceSearch();
        int firstOccurPos = bfs.search(text, pattern);
        System.out.println("The text '" + pattern + "' is first found after the " + firstOccurPos + " position.");
    }
}
