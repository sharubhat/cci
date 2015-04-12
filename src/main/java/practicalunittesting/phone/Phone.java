package practicalunittesting.phone;

/**
 * Created by sharath on 4/10/15.
 */
public class Phone {
    private final boolean mobile;
    private final String number;

    public Phone(String number) {
        this.number = number;
        this.mobile = number.startsWith("+") && number.endsWith("9");
    }

    public Phone(String number, boolean mobile) {
        this.mobile = mobile;
        this.number = number;
    }

    public boolean isMobile() {
        return mobile;
    }
}
