package threads.concurrency_cookbook.chapter4._6_running_task_with_delay;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 5/17/15.
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executor = (ScheduledExecutorService) Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s \n", new Date());
        for(int i = 0; i < 5; i++) {
            Task task = new Task("Task " + i);
            executor.schedule(task, i + 1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            // if the timeout is shorter than time needed to finish the tasks,
            // then the control just passes to next line. So, if you are using this to find out
            // if the tasks have finished, then keep a long timeout.
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Ends at: %s\n", new Date());
    }
}
