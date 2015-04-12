package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sharath on 4/5/15.
 * Ref: http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
 */
public class ExtractDemo {
    public static void main(String[] args) {
        String input = "I have a cat, but I like my dog better.";

        // ()		group everything within the parenthesis as group 1
        // mouse		match the text ‘mouse’
        // |		alternation: match any one of the sections of this group
        // cat		match the text ‘cat’ ... and other words
        Pattern p = Pattern.compile("(mouse|cat|dog|wolf|bear|human)");
        Matcher m = p.matcher(input);

        List<String> animals = new ArrayList<>();
        while(m.find()) {
            System.out.println("Found a " + m.group() + ".");
            animals.add(m.group());
        }
    }
}
