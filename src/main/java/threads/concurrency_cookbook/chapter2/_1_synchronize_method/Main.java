package threads.concurrency_cookbook.chapter2._1_synchronize_method;

/**
 * Created by sharath on 1/31/15.
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        System.out.printf("Account: Initial Balance: %f\n",
                account.getBalance());

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n",
                    account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
