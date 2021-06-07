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

        String clientId = "tid=4&ci=90232642%3B20000000%3B20000001%3B30000001%3B30004001%3B90380716%3B90380768%3B90380755%3B90380742%3B90380729%3B32000001%3B32004001%3B32000091%3B72009999%3B80000001%3B30001001%3B50280000%7CDEMO%3B59000000%7CcmTest9%3B59040000%7CcmTestL12%3B50000000%7CSuper%20Leisure%20International%3B50010000%7CSuper%20Leisure%20International&vn2=e4.0&st=1475609250355&vn1=4.18.138&ec=utf-8&pr=FULO-0101&pm=White%20Fabric%20Roll%20Arm%20Chaise&qt=1&bp=499.99&cg=Lounge%20Chairs&at=5&pc=N&rnd=1475609977138&ul=http%3A%2F%2Fretail-demo.coremetrics.com%2FLiveDemo%2FshoppingCart&rf=http%3A%2F%2Fretail-demo.coremetrics.com%2FLiveDemo%2Fproduct%3Fcatalog_id%3D1%26category_id%3D1%26prod_id%3D1%26cm_vc%3DCARTZ1&cjen=1&cjuid=91238989268514599699370&cjsid=1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938|1472582938||1472497682|1472500216|1472497682&cjvf=33|33|33|33|33|33|33|33|33|33|33|33|33|33|33|33|33||33|33|33";

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

        if(clientId.matches("(^(?=.*ci=.*59000000.*)(?=.*tid=(4|5)).*$)|(^(?=.*ci=.*30000001.*)(?=.*tid=(4|5)).*$)")) {
            System.out.println("Matched");
        }
        if(clientId.matches("(.*ci=.*59000000.*&tid=(4|5).*)|(.*ci=.*30000001.*&tid=(4|5).*)"))
            System.out.println("Found matching string");
    }
}
