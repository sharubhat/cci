package threads.concurrency_cookbook.chapter1._9_local_thread_variable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 1/31/15.
 */
public class SafeTask implements Runnable {
    private static ThreadLocal<Date> startDate =
            new ThreadLocal<Date>() {
                @Override
                protected Date initialValue() {
                    return new Date();
                }
            };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",
                Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",
                Thread.currentThread().getId(), startDate.get());
    }
}
