package threads_book;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sharath on 3/29/15.
 * <p>
 * Threads should print alternatively.
 */
public class Print implements Runnable {
  private final AtomicInteger count = new AtomicInteger(0);

  @Override
  public void run() {
    while (count.get() < 11) {
      synchronized (this) {
        System.out.printf("%s  - %d%n", Thread.currentThread().getName(), count.get());
        count.incrementAndGet();
      }
      // If there is no sleep then thread which has first acquired mutex will start processing the
      // next instruction before another thread can acquire the lock.
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void main(String[] args) {
    Print p = new Print();
    Thread t1 = new Thread(p, "Thread 1");
    Thread t2 = new Thread(p, "Thread 2");
    t1.start();
    t2.start();
  }
}
