package threads.concurrency_cookbook.chapter4._7_running_task_periodically;

import java.util.Date;

/**
 * Created by sharath on 5/17/15.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        System.out.printf("%s: Starting at : %s\n", name, new Date());
    }
}
