package threads.concurrency_cookbook.chapter1._3_thread_interrupt;

/**
 * Created by sharath on 1/29/15.
 *
 * Notes:
 * isInterrupted() doesn't change the value of the interrupted attribute
 * but interrupted() sets it to false.
 *
 * Since interrupted is static method, use of isInterrupted() is recommended
 *
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while(true) {
            if(isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            if(isInterrupted()) {
                System.out.printf("The prime generator has been interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long num) {
        if(num > 2) {
            for (long i = 2L; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
