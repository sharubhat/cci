package threads.concurrency_cookbook.chapter4._4_process_single_result;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 4/28/15.
 */
public class UserValidator {
    private String validatorName;

    public UserValidator(String name) {
        this.validatorName = name;
    }

    public boolean valdiate(String user, String password) {
        Random random = new Random();
        try{
            long duration  = (long)(Math.random() * 10);
            System.out.printf("Validator %s: Validating a user during %d seconds\n", this.validatorName, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }

    public String getValidatorName() {
        return validatorName;
    }
}
