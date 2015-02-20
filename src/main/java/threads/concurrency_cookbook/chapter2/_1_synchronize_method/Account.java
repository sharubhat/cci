package threads.concurrency_cookbook.chapter2._1_synchronize_method;

import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 1/31/15.
 */
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void addAmount(double amt) {
        double tmp = balance;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amt;
        balance = tmp;
    }

    public synchronized void subtractAmount(double amt) {
        double tmp = balance;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amt;
        balance = tmp;
    }
}
