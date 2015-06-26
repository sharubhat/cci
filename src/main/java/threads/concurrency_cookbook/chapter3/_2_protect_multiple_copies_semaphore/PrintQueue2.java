package threads.concurrency_cookbook.chapter3._2_protect_multiple_copies_semaphore;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sharath on 4/30/15.
 */
public class PrintQueue2 {
    private boolean freePrinters[];
    private Semaphore semaphore;
    private Lock lockPrinters;

    public PrintQueue2() {
        this.semaphore = new Semaphore(3);
        this.lockPrinters = new ReentrantLock();
        this.freePrinters = new boolean[3];
        Arrays.fill(freePrinters, true);
    }

    public void printJob(Object doc) {
        try {
            semaphore.acquire();
            int assignPrinter = getPrinter();
            print(assignPrinter);
            freePrinters[assignPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        lockPrinters.lock();
        try {
            for(int i = 0; i < 3; i++) {
                if(freePrinters[i]) {
                    freePrinters[i] = false;
                    return i;
                }
            }
        } finally {
            lockPrinters.unlock();
        }
        return -1;
    }

    private void print(int assignedPrinter) {
        System.out.println(Thread.currentThread().getName() + " : " + assignedPrinter);
    }
}
