package threads.concurrency_cookbook.chapter1._12_factory;

import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 1/31/15.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
