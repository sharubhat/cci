package threads.concurrency_cookbook.chapter1._8_uncontrolled_exception;

/**
 * Created by sharath on 1/31/15.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int n = Integer.parseInt("TTT");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Task());
        t.setUncaughtExceptionHandler(new ExceptionHandler());
        t.start();
    }
}
