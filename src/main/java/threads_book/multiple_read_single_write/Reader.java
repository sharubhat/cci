package threads_book.multiple_read_single_write;

/**
 * Created by sharath on 3/29/15.
 */
public class Reader implements Runnable {
    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.printf("%s: Price 1: %f\n", Thread.
                    currentThread().getName(),priceInfo.getPrice1());
            System.out.printf("%s: Price 2: %f\n", Thread.
                    currentThread().getName(),priceInfo.getPrice2());
        }
    }
}
