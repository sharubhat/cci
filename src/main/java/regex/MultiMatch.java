package regex;

/**
 * Created by sharath on 4/11/15.
 */
public class MultiMatch {
    public static void main(String[] args) {
        String line = "\tInstalling NETCARD\n" +
                "\tInstalling TCPIP\n" +
                "\tTCPIP\n" +
                "\tNETCARD\n";

        System.out.println(line.matches("(.|\\s)*(TCPIP)(.|\\s)*(TCPIP)(.|\\s)*"));
    }
}
