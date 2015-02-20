package threads.concurrency_cookbook.chapter1._9_local_thread_variable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 1/31/15.
 */
public class UnsafeTask implements Runnable {
    private Date startDate;
    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting thread: %s : %s\n",
                Thread.currentThread().getId(), startDate);
        try {
            int wait = (int)Math.rint(Math.random()*10);
            TimeUnit.SECONDS.sleep(wait);
            System.out.printf("Thread %s wait is %d\n",
                    Thread.currentThread().getId(), wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",
                Thread.currentThread().getId(), startDate);
    }
}
