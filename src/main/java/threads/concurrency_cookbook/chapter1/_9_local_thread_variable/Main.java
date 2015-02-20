package threads.concurrency_cookbook.chapter1._9_local_thread_variable;

import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 1/31/15.
 */
public class Main {
    public static void main(String[] args) {
        UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("****************************");

        SafeTask stask = new SafeTask();
        for (int i= 0; i < 10; i++) {
            Thread t = new Thread(stask);
            t.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
