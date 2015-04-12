package threads_book.multiple_read_single_write;

/**
 * Created by sharath on 3/29/15.
 */
public class Main {
    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();

        Thread[] threadReaders = new Thread[5];

        for(int i = 0; i < 5; i++) {
            threadReaders[i] = new Thread(new Reader(priceInfo));
        }

        Writer writer = new Writer(priceInfo);
        Thread threadWriter = new Thread(writer);

        for(int i = 0; i < 5; i++) {
            threadReaders[i].start();
        }
        threadWriter.start();
    }
}
