package threads.concurrency_cookbook.chapter2._6_lock_fairness;

/**
 * Created by sharath on 2/1/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue =  new PrintQueue();
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
        }
        for(int i = 0; i < 10; i++) {
            threads[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
