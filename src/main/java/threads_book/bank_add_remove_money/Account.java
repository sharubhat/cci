package threads_book.bank_add_remove_money;

import java.util.concurrent.TimeUnit;

/**
 * Created by vandana on 3/29/15.
 */
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void addAmount(double money) {
        double tmp = balance;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += money;
        balance = tmp;
        System.out.println("Added, new balance is " + balance);
    }

    public synchronized void subtractAmount(double money) {
        double tmp = balance;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= money;
        balance = tmp;
        System.out.println("Subtracted, new balance is " + balance);
    }
}