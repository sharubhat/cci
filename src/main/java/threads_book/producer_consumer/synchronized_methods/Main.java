package threads_book.producer_consumer.synchronized_methods;

/**
 * Created by sharath on 3/29/15.
 */
public class Main {
    public static void main(String[] args) {
        EventStorage store = new EventStorage();
        new Thread(new Producer(store)).start();
        new Thread(new Consumer(store)).start();
    }
}
