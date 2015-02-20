package threads.concurrency_cookbook.chapter2._3_wait_notify;

/**
 * Created by sharath on 2/1/15.
 */
public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t2.start();
        t1.start();
    }
}
