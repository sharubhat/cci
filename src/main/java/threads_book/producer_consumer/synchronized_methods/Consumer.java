package threads_book.producer_consumer.synchronized_methods;

/**
 * Created by sharath on 3/29/15.
 */
public class Consumer implements Runnable {
    private EventStorage store;

    public Consumer(EventStorage store) {
        this.store = store;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            store.get();
        }
    }
}
