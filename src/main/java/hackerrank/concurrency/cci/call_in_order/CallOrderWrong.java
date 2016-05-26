package hackerrank.concurrency.cci.call_in_order;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sharath on 5/25/16.
 */
public class CallOrderWrong {
    public Lock lock1, lock2;

    public CallOrderWrong() {
        lock1 = new ReentrantLock();
        lock2 = new ReentrantLock();

        lock1.lock();
        lock2.lock();
    }

    public void first() {
        System.out.println("First method : " + Thread.currentThread().getName());
        lock1.unlock();
    }

    public void second() {
        lock1.lock();
        lock1.unlock();
        System.out.println("Second method : " + Thread.currentThread().getName());
        lock2.unlock();
    }

    public void third() {
        lock2.lock();
        lock2.unlock();
        System.out.println("Third method : " + Thread.currentThread().getName());
    }
}
