package hackerrank.concurrency.barrier;

import java.util.concurrent.Semaphore;

/**
 * Created by sharath on 10/4/15.
 */
public class ThreadA extends Thread {
    Semaphore semA;
    Semaphore semB;

    public ThreadA(Semaphore s1, Semaphore s2) {
        this.semA = s1;
        this.semB = s2;
    }

    @Override
    public void run() {
        System.out.println("A1");
        semA.release();
        try {
            semB.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A2");
    }
}
