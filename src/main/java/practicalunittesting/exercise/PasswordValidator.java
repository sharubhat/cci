package practicalunittesting.exercise;

/**
 * Created by sharath on 4/5/15.
 */
public class PasswordValidator {
    public boolean validate(String password) {
        if(password == null || password.isEmpty())
            throw new InvalidPasswordException("Empty password");
        if(password.toLowerCase().equals(password))
            throw new InvalidPasswordException("Password should contain at least one uppercase character");
        if(!password.contains("[0-9]"))
            throw new InvalidPasswordException("Password should contain at least one digit");
        return false;
    }
}
