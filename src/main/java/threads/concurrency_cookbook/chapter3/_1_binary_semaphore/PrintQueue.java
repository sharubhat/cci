package threads.concurrency_cookbook.chapter3._1_binary_semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by sharath on 2/2/15.
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: printing a Job during %d seconds\n",
                    Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
