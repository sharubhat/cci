package threads_book.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 3/28/15.
 */
public class PrimeGenerator implements Runnable {
    @Override
    public void run() {
        long num = 1L;

        while(true) {
            if(isPrime(num)) {
                System.out.println(num);
            }
            num++;

            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Prime number generation for interrupted");
                break;
            }
        }
    }

    private boolean isPrime(long number) {
        if (number <=2) {
            return true;
        }
        for (long i=2; i<number; i++){
            if ((number % i)==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread t = new Thread(new PrimeGenerator());
        t.start();

        try {
            TimeUnit.SECONDS.sleep(5);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
