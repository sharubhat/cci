package hackerrank.concurrency.multiplex;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 10/4/15.
 */
public class ThreadA extends Thread {
    Semaphore mutex;
    int sleepTime;

    public ThreadA(Semaphore mutex, int sleepTime) {
        this.mutex = mutex;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.printf("Inside %s, sleeping for %d seconds%n", Thread.currentThread().getName(), this.sleepTime);
        try {
            TimeUnit.SECONDS.sleep(this.sleepTime);
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Inside %s, woke up, acquired mutex%n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(this.sleepTime * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Inside %s, releasing mutex%n", Thread.currentThread().getName());
        mutex.release();
    }
}
