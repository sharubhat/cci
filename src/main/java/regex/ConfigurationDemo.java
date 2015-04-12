package regex;

/**
 * Created by sharath on 4/6/15.
 * Ref : http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-2/
 */
public class ConfigurationDemo {
    public static void main(String[] args) {
        String input = "My dog is Blue.\n" +
                "He is not red or green.";

        print("Control result was: " + input.matches("(?=.*Green.*).*Blue.*"));
        print("Case ins. result was: " + input.matches("(?i)(?=.*Green.*).*Blue.*"));
        print("Dot-all result was: " + input.matches("(?s)(?=.*Green.*).*Blue.*"));
        // (?si)			    turn on case insensitivity and dot-all modes
        // (?=.*Green.*) 		‘Green’ must be found somewhere to the right of this look-ahead
        // .*Blue.*		        ‘Blue’ must be found somewhere in the input
        print("Configured result was: " + input.matches("(?si)(?=.*Green.*).*Blue.*"));
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
