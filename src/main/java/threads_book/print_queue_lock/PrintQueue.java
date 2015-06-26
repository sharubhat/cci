package threads_book.print_queue_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sharath on 3/29/15.
 */
public class PrintQueue {
    private final Lock lock = new ReentrantLock();

    public void print() {
        lock.lock();
        try {
            System.out.printf("Printing... %s\n", Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
