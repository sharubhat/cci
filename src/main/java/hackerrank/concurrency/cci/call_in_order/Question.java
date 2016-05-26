package hackerrank.concurrency.cci.call_in_order;

/**
 * Suppose we have the following code:
 * public class CallOrder {
 *     public CallOrder(){...}
 *     public void first(){...}
 *     public void second(){...}
 *     public void third(){...}
 * }
 * The same instance will be passed to three different threads. ThreadA will call first, ThreadB will
 * call second, and ThreadC will call third. Design a mechanism to ensure that first is called
 * before second and second is called before third.
 *
 * Note: The code won't work if we use ReentrantLock instead of Semaphore due to concept of lock ownership.
 * Lock is owned by the same thread that locks it and throws IllegalMonitorStateException if other threads try to unlock.
 * However Semaphore is system wide and is not owned by the thread that acquires it(can be released by other thread).
 *
 * Created by sharath on 5/25/16.
 */
public class Question {
    public static void main(String[] args) {
        CallOrder callOrder = new CallOrder();

        MyThread t1 = new MyThread(callOrder, "first");
        MyThread t2 = new MyThread(callOrder, "second");
        MyThread t3 = new MyThread(callOrder, "third");

        t1.start();
        t2.start();
        t3.start();
    }
}
