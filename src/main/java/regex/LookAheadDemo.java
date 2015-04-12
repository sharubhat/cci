package regex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 4/6/15.
 * Ref : http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-2/
 *
 * (?:X) 			X, as a non-capturing group
 * (?=X) 			X, via zero-width positive(matches) look-ahead
 * (?!X) 			X, via zero-width negative(not present) look-ahead
 * (?<=X) 			X, via zero-width positive look-behind
 * (?<!X) 			X, via zero-width negative look-behind
 * (?<X) 			X, as an independent, non-capturing group
 */
public class LookAheadDemo {
    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        input.add("password");
        input.add("p4ssword");
        input.add("p4ssw0rd");
        input.add("p45sword");
        input.add("1password");
        input.add("12password");

        for(String pass : input) {
            // ^				        match the beginning of the line
            // (?=.*[0-9].*[0-9]) 		a positive look-ahead expression, requires 2 digits to be present anywhere in input in any order
            // .*				        match n characters, where n >= 0
            // [0-9]				    match a digit from 0 to 9
            // [0-9a-zA-Z]			    match any numbers or letters
            // {8,12}				    match 8 to 12 of whatever is specified by the last group
            // $				        match the end of the line
            if(pass.matches("^(?=.*[0-9].*[0-9])[0-9a-zA-Z]{8,12}$")) {
                System.out.println(pass + " : matches");
            } else {
                System.out.println(pass + " : does not match");
            }
        }

        System.out.println("************************************");

        for(String pass : input) {
            // ^				        match the beginning of the line
            // (?!.*[0-9])       		a negative look-ahead expression, requires no digit to be present anywhere in input
            // .*				        match n characters, where n >= 0
            // [0-9]				    match a digit from 0 to 9
            // [0-9a-zA-Z]			    match any numbers or letters
            // {8,12}				    match 8 to 12 of whatever is specified by the last group
            // $				        match the end of the line
            if(pass.matches("^(?!.*[0-9])[a-zA-Z]{8,12}$")) {
                System.out.println(pass + " : matches");
            } else {
                System.out.println(pass + " : does not match");
            }
        }
    }
}
