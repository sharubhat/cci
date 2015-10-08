package hackerrank.concurrency.mutex;

import java.util.concurrent.Semaphore;

/**
 * Semaphore can be used to enforce mutual exclusion.
 * Puzzle: Add semaphores to the following example to enforce mutual exclusion to the shared variable count.
   Thread A               Thread B
 count = count + 1      count = count + 1

 We want to guarantee that count read by one thread is not modified by other thread before thread 1 updates it.
 We don’t care about the order of thread 1 and 2.

 Since mutex is initially 1, whichever thread gets to the acquire first will be able to proceed immediately.
 Of course, the act of acquiring on the semaphore has the effect of decrementing it,
 so the second thread to arrive will have to wait until the first releases.

 Note: Thread A and B can be objects of different classes or same - doesn't matter.

 *
 * Created by sharath on 10/4/15.
 */
public class Main {
    public static int count = 0;

    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);

        Thread a = new ThreadA(mutex, 5);
        a.setName("A");
        Thread b = new ThreadA(mutex, 2);
        b.setName("B");

        a.start();
        b.start();
    }
}
