package others;

import java.util.Arrays;

/**
 * Created by sharath on 8/21/16.
 */
public class RegexSplit {
    public static void main(String[] args) {
        String s = "This, is solid; hello-world time.waste ";

        System.out.println(Arrays.asList(s.split("([\\s,]|;|\\.|-)+")));
    }
}
