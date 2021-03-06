package threads.concurrency_cookbook.chapter2._4_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sharath on 2/1/15.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long)(Math.random() * 1000);
            System.out.printf("%s : PrintQueue: Printing a Job during %d seconds\n",
                    Thread.currentThread().getName(), duration/1000);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
