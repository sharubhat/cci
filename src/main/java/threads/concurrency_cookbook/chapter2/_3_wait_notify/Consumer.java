package threads.concurrency_cookbook.chapter2._3_wait_notify;

/**
 * Created by sharath on 2/1/15.
 */
public class Consumer implements Runnable {
    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
