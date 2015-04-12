package threads_book.bank_add_remove_money;

import java.util.concurrent.TimeUnit;

/**
 * Created by vandana on 3/29/15.
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            account.subtractAmount(1000);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
