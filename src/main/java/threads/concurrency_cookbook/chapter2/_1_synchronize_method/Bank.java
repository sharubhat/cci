package threads.concurrency_cookbook.chapter2._1_synchronize_method;

/**
 * Created by sharath on 1/31/15.
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subtractAmount(1000);
        }
    }
}
