package threads.concurrency_cookbook.chapter1._6_waiting_for_finalization;

import java.util.Date;

/**
 * Created by sharath on 1/29/15.
 */
public class Main {
    public static void main(String[] args) {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread t1 = new Thread(dsLoader, "DataSourceLoader");

        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread t2 = new Thread(ncLoader);

        t1.start();
        t2.start();

        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
    }
}
