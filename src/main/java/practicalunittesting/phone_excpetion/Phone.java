package practicalunittesting.phone_excpetion;

/**
 * Created by sharath on 4/11/15.
 */
public class Phone {
    private String number;

    public void setNumber(String number) {
        if(null == number || number.isEmpty()) {
            throw new IllegalArgumentException(
                    "number can not be empty or null"
            );
        }
        if(number.startsWith("+")) {
            throw new IllegalArgumentException(
                    "plus sign prefix not allowed, number: [" + number + "]"
            );
        }
        this.number = number;
    }
}
