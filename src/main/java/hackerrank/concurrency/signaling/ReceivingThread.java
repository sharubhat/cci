package hackerrank.concurrency.signaling;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 10/4/15.
 */
public class ReceivingThread extends Thread {
    Semaphore semaphore;

    public ReceivingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Inside receiver, sleeping for 20 seconds");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        System.out.println("Semaphore released by " + Thread.currentThread().getName());
        System.out.println("Sleeping for 20 seconds inside receiver");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Receiver complete");
    }
}
