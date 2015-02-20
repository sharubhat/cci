package threads.concurrency_cookbook.chapter2._5_read_write_locks;

/**
 * Created by sharath on 2/1/15.
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
            priceInfo.setPrice(Math.random()*10, Math.random()*8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
