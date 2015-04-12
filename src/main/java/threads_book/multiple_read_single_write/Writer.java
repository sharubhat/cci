package threads_book.multiple_read_single_write;

/**
 * Created by sharath on 3/29/15.
 */
public class Writer implements Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.printf("Writer: Attempt to modify the prices.\n");
            priceInfo.setPrices(Math.random()*10, Math.random()*8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
