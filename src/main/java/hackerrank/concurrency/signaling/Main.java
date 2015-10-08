package hackerrank.concurrency.signaling;

import java.util.concurrent.Semaphore;

/**
 * Semaphore can be used for signalling between threads. i.e. when a thread should not start until other is complete.
 * Created by sharath on 10/4/15.
 */
public class Main {
    public static void main(String[] args) {
        // what semaphore is initialized to makes a huge difference here.
        // if initialized to n > 0, sender doesn't wait for receiver to release as it can acquire a semaphore
        // if initialized to 0, sender waits exactly until receiver releases the semaphore
        // if initialized to n < 0, sender waits forever as count doesn't become positive
        Semaphore sem = new Semaphore(0);
        Thread t1 = new ReceivingThread(sem);
        t1.setName("Receiver");
        Thread t2 = new SendingThread(sem);
        t2.setName("Sender");

        t2.start();
        t1.start();
    }
}
