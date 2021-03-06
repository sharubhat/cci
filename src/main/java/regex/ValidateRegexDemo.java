package regex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 4/5/15.
 *
 * Ref: http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
 */
public class ValidateRegexDemo {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();

        input.add("123-45-6789");
        input.add("9876-5-4321");
        input.add("987-65-4321 (attack)");
        input.add("987-65-4321 ");
        input.add("192-83-7465");
        input.add("192837465");

        String clientId = "55555456543212999474257,1455840673000000000059000000,?ci=30000001&st=1455840672531&cjvf=1&tid=7&cg=Burlingame";

        for(String ssn : input) {
            // P.S: Java requires \\ for \ when pattern is given as string
            // ^		match the beginning of the line
            // () 		group everything within the parenthesis as group 1
            // \d{n}	match n digits, where n is a number equal to or greater than zero
            // -?		optionally match a dash
            // $		match the end of the line
            if(ssn.matches("^(\\d{3})-?(\\d{2})-?(\\d{4})$"))
                System.out.println("Found a good SSN - " + ssn);
        }

        if(clientId.matches("(.*ci=.*59000001.*&tid=(4|5).*)|(.*ci=.*30000001.*&tid=(4|5).*)"))
            System.out.println("Found matching string");
    }
}
