package threads_book;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sharath on 3/29/15.
 *
 * Threads should print alternatively.
 * This is better than other solution because
 * 1. Using lock instead of synchronized block is a win in terms of performance,
 * 2. No sleep required after coming out of the critical section.
 * 3. Also, setting Lock Fairness to true (i.e. ReentrantLock(true) instead of ReentrantLock()) forces the lock to
 * select the thread that has been waiting for the most time ensuring proper synchronization.
 */
public class PrintLock implements Runnable {
    private Lock lock;
    private int count;

    public PrintLock() {
        this.lock = new ReentrantLock(true);
    }

    @Override
    public void run() {
        while(true) {
            lock.lock();
            if(count < 11) {
                System.out.printf("%s - %d\n", Thread.currentThread().getName(), count);
                count++;
            }
            else {
                lock.unlock();
                break;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintLock printLock = new PrintLock();

        Thread t1 = new Thread(printLock);
        Thread t2 = new Thread(printLock);

        t1.start();
        t2.start();
    }
}


