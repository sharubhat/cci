package others.dropbox;

import java.util.Arrays;

/**
 * Created by sharath on 8/22/15.
 */
public class CountDigits {
    public static void main(String[] args) {
        String[] in = {"12", "21"};
        String[] result = say_what_you_see(in);
        Arrays.toString(result);
    }

    static String[] say_what_you_see(String[] input_strings) {

        String[] result = new String[input_strings.length];

        for (int index = 0; index < input_strings.length; index++) {
            String s = input_strings[index];
            StringBuilder sb = new StringBuilder();
            char curr = s.charAt(0);
            int count = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == curr) {
                    count++;
                } else {
                    sb.append(count).append(curr);
                    curr = s.charAt(i);
                    count = 1;
                }
            }
            sb.append(count).append(curr);
            result[index] = sb.toString();
        }

        return result;
    }
}
