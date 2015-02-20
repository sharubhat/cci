package threads.concurrency_cookbook.chapter1._1_create_run_thread;

/**
 * Created by sharath on 1/29/15.
 */
public class Calculator implements Runnable {
    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",
                    Thread.currentThread().getName(), number, i, number * i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i <= 10; i++) {
            new Thread(new Calculator(i)).start();
        }
    }
}
