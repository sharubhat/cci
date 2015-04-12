package threads_book.producer_consumer.using_locks;

/**
 * Created by sharath on 3/29/15.
 */
public class Main {
    public static void main(String[] args) {
        FileMock fileMock = new FileMock(100, 10);

        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(fileMock, buffer);
        Thread tProducer = new Thread(producer, "Producer");

        Consumer[] consumers = new Consumer[3];
        Thread[] tConsumers = new Thread[3];

        for(int i = 0;i < 3; i++) {
            tConsumers[i] = new Thread(new Consumer(buffer));
        }

        tProducer.start();

        for(int i = 0; i < 3; i++) {
            tConsumers[i].start();
        }
    }
}
