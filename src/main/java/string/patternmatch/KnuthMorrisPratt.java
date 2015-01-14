package string.patternmatch;

/**
 * Created by sharath on 10/24/14.
 */
public class KnuthMorrisPratt {
    public int[] prekmp(char[] pattern) {
        int[] next = new int[pattern.length + 1];
        int i = 0, j = -1;
        next[i] = j;
        while (i < pattern.length) {
            while (j >= 0 && pattern[i] != pattern[j])
                j = next[j];
            i++;
            j++;
            next[i] = j;
        }
        return next;
    }

    public int kmp(String text, String pattern) {
        int[] next = prekmp(pattern.toCharArray());
        int i = 0, j = 0;
        while(i < text.length()) {
            while(j >= 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            i++;
            j++;
            if(j == pattern.length())
                return i - pattern.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        KnuthMorrisPratt k = new KnuthMorrisPratt();
        String text = "Lorem ipsum dolor sit amet";
        String pattern = "ipsum";

        int first_occur_position = k.kmp(text, pattern);
        System.out.println("The text '" + pattern + "' is first found on the "
                + first_occur_position + " position.");
    }
}
