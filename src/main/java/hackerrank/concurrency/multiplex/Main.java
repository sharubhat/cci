package hackerrank.concurrency.multiplex;

import java.util.concurrent.Semaphore;

/**
 * Puzzle: Generalize the previous solution for mutex so that it allows multiple threads to
 run in the critical section at the same time, but it enforces an upper limit on
 the number of concurrent threads. In other words, no more than n threads can
 run in the critical section at the same time.
 *
 * Created by sharath on 10/4/15.
 */
public class Main {
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(2);

        Thread a = new ThreadA(mutex, 3);
        a.setName("A");
        Thread b = new ThreadA(mutex, 2);
        b.setName("B");
        Thread c = new ThreadA(mutex, 3);
        c.setName("C");
        Thread d = new ThreadA(mutex, 2);
        d.setName("D");
        Thread e = new ThreadA(mutex, 3);
        e.setName("E");
        Thread f = new ThreadA(mutex, 2);
        f.setName("F");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
    }
}
