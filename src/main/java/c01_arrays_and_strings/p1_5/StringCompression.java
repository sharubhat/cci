package c01.arrays.and.strings.p1_5;

/**
 * Created by sharath on 8/2/14.
 *
 * Problem description:
 * Compress using count of repeated characters
 * aabcccccaaa should become a2b1c5a3
 * If compressed string would not be smaller than original, then return original
 *
 * Questions to ask:
 * Can't think of any
 */
public class StringCompression {
    public String compress(String input) {
        if(input == null || input.length() == 0)
            throw new IllegalArgumentException("Invalid input");

        if(calculateSize(input) >= input.length())
            return input;

        StringBuilder sb = new StringBuilder();

        char curr = input.charAt(0);
        int count = 1;
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i) == input.charAt(i - 1)) {
                count ++;
            }
            else {
                sb.append(curr);
                sb.append(count);
                curr = input.charAt(i);
                count = 1;
            }
        }
        sb.append(curr);
        sb.append(count);

        return sb.toString();
    }

    private int calculateSize(String input) {
        int size = 0;
        int charCount = 1;
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i) == input.charAt(i - 1)) {
                charCount++;
            }
            else {
                size += 1 + String.valueOf(charCount).length();
                charCount = 1;
            }
        }
        size += 1 + String.valueOf(charCount).length();
        return size;
    }
}
