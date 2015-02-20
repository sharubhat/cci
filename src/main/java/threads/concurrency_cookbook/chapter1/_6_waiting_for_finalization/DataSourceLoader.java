package threads.concurrency_cookbook.chapter1._6_waiting_for_finalization;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 1/29/15.
 */
public class DataSourceLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n", new Date());
    }
}
