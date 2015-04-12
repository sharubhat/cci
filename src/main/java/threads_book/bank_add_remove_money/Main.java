package threads_book.bank_add_remove_money;

/**
 * Created by vandana on 3/29/15.
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000);

        Bank bank = new Bank(account);
        Company company = new Company(account);
        Thread tBank = new Thread(bank);
        Thread tCompany = new Thread(company);

        tBank.start();
        tCompany.start();

        try {
            tBank.join();
            tCompany.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance());

    }
}
