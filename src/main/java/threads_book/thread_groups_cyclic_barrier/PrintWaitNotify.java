package threads_book.thread_groups_cyclic_barrier;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintWaitNotify implements Runnable {
  private AtomicInteger count;
  private boolean oddPrinter;
  private volatile int upperLimit;

  public PrintWaitNotify(boolean oddPrinter, AtomicInteger count, int upperLimit) {
    this.count = count;
    this.oddPrinter = oddPrinter;
    this.upperLimit = upperLimit;
  }

  @Override
  public void run() {
    while (count.get() < upperLimit) {
      if (count.get() % 2 == 0 ^ oddPrinter) {
        synchronized (count) {
          try {
            wait();
          } catch (InterruptedException e) {

          }
          System.out.println(count.get() + " " + oddPrinter);
          System.out.println(Thread.currentThread().getName() + " - " + count.incrementAndGet());
          count.notifyAll();
        }
      }
    }
  }

  public static void main(String[] args) {
    AtomicInteger count = new AtomicInteger();
    new Thread(new PrintWaitNotify(true, count, 100)).start();
    new Thread(new PrintWaitNotify(false, count, 100)).start();
  }
}
