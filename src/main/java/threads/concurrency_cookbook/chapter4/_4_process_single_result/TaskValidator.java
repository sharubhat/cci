package threads.concurrency_cookbook.chapter4._4_process_single_result;

import java.util.concurrent.Callable;

/**
 * Created by sharath on 4/28/15.
 */
public class TaskValidator implements Callable<String> {
    private UserValidator validator;
    private String user;
    private String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if(validator.valdiate(user, password)) {
            System.out.printf("%s: The user has not been found\n", validator.getValidatorName());
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: The user has been found\n", validator.getValidatorName());
        return validator.getValidatorName();
    }
}
