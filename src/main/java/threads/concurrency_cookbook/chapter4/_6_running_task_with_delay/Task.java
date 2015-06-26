package threads.concurrency_cookbook.chapter4._6_running_task_with_delay;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by sharath on 5/17/15.
 */
public class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
        return "Hello World";
    }
}
