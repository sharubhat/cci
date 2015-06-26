package threads.concurrency_cookbook.chapter4._5_process_all_results;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 4/28/15.
 */
public class Task implements Callable<Result> {
    private String name;


    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Starting\n", this.name);
        try {
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s: waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int value = 0;
        for(int i = 0; i < 5; i++) {
            value += (int)(Math.random()*100);
        }
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        System.out.println(this.name + " : Ends");
        return result;
    }
}
