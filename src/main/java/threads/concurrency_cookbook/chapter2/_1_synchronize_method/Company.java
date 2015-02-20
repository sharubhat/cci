package threads.concurrency_cookbook.chapter2._1_synchronize_method;

/**
 * Created by sharath on 1/31/15.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i< 10; i++) {
            account.addAmount(1000);
        }
    }
}
