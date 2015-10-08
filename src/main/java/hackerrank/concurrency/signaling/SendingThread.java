package hackerrank.concurrency.signaling;

import java.util.concurrent.Semaphore;

/**
 * Created by sharath on 10/4/15.
 */
public class SendingThread extends Thread {
    Semaphore semaphore;

    public SendingThread(Semaphore sem) {
        this.semaphore = sem;
    }

    @Override
    public void run() {
        System.out.println("Inside sender, waiting for the semaphore");
        try {
            semaphore.acquire();
            System.out.println("Semaphore acquired by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
