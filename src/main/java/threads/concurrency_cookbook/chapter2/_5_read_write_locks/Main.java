package threads.concurrency_cookbook.chapter2._5_read_write_locks;

/**
 * Created by sharath on 2/1/15.
 */
public class Main {
    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();
        Reader[] readers = new Reader[5];
        Thread[] threadsReader = new Thread[5];
        for(int i = 0; i < 5; i++) {
            readers[i] = new Reader(priceInfo);
            threadsReader[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(priceInfo);
        Thread threadWriter =  new Thread(writer);
        for(int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}
