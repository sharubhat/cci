package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sharath on 4/5/15.
 * Ref: http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
 */
public class ReplaceDemo {
    public static void main(String[] args) {
        String input =
                "User clientId=23421. Some more text clientId=33432. This clientNum=100";

        // (clientId=) 	group everything within the parenthesis as group 1
        // clientId=	match the text ‘clientId=’
        // (\\d+)		group everything within the parenthesis as group 2
        // \\d+		match one or more digits

        /*
        * Notice how groups begin numbering at 1, and increment by one for each new group.
        * However; groups may contain groups, in which case the outer group begins at one,
        * group two will be the next inner group. When referencing group 0,
        * you will be given the entire chunk of text that matched the regex.
        *
        * (  ( ) (  ( ) ( ))) ( )	    //and so on
        *  1  2   3  4   5     6		//0 = everything the pattern matched
        */

        Pattern p = Pattern.compile("(clientId=)(\\d+)");
        Matcher m = p.matcher(input);

        StringBuffer result = new StringBuffer();
        result.append("This is what I am expecting to see : ");
        while(m.find()) {
            System.out.println("Making: " + m.group(2));
            // m matches say 'clientId=23421', replace it with 'clientId=***masked***' and append it to buffer
            m.appendReplacement(result, m.group(1) + "***masked***");
        }
        m.appendTail(result);
        System.out.println(result);
    }
}
