package practicalunittesting.exercise;

/**
 * Created by sharath on 4/5/15.
 */
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
