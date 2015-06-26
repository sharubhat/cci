package threads.concurrency_cookbook.chapter4._3_task_with_return;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 4/27/15.
 */
public class FactorialCalculator implements Callable<Integer> {
    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if(number == 0 || number == 1) {
            result = 1;
        } else {
            for(int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.println(Thread.currentThread().getName() + " : factorial of " + number + " is " + result);
        return result;
    }
}
