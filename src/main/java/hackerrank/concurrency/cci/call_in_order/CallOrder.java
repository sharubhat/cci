package hackerrank.concurrency.cci.call_in_order;

import java.util.concurrent.Semaphore;

/**
 *
 * Created by sharath on 5/25/16.
 */
public class CallOrder {
    public Semaphore sem1, sem2;

    public CallOrder() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);

            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void first() {
        System.out.println("First method : " + Thread.currentThread().getName());
        sem1.release();
    }

    public void second() {
        try {
            sem1.acquire();
            sem1.release();
            System.out.println("Second method : " + Thread.currentThread().getName());
            sem2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            sem2.acquire();
            sem2.release();
            System.out.println("Third method : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
