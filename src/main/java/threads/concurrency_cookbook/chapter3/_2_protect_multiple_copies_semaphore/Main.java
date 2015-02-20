package threads.concurrency_cookbook.chapter3._2_protect_multiple_copies_semaphore;

/**
 * Created by sharath on 2/2/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
        }
        for(Thread t : threads) {
            t.start();
        }
    }
}
