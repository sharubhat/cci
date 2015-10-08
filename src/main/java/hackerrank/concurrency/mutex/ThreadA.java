package hackerrank.concurrency.mutex;

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
        System.out.printf("Inside %s, woke up, acquired mutex, count = %d%n", Thread.currentThread().getName(), Main.count);
        Main.count++;
        System.out.printf("Inside %s, count = %d, releasing mutex%n", Thread.currentThread().getName(), Main.count);
        mutex.release();
    }
}
