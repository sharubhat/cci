package hackerrank.concurrency.rendezvous;

import java.util.concurrent.Semaphore;

/**
 * Created by sharath on 10/4/15.
 */
public class ThreadB extends Thread {
    Semaphore semA;
    Semaphore semB;

    public ThreadB(Semaphore s1, Semaphore s2) {
        this.semA = s1;
        this.semB = s2;
    }

    @Override
    public void run() {
        System.out.println("B1");
        semB.release();
        try {
            semA.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B2");
    }
}
