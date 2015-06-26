package threads.concurrency_cookbook.chapter4._2_fixed_size_executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * A simple task that does nothing but sleep for random amount of time.
 * This sleep is like a place holder for any real task. This task/thread could be executed in any way.
 * However we will be feeding this to a task executor server to process the task.
 *
 * Created by sharath on 2/6/15.
 */
public class Task implements Runnable {
    private final Date initDate;
    private final String name;

    public Task(String name) {
        this.initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
        try {
            Long duration = (long)(Math.random() * 10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}
