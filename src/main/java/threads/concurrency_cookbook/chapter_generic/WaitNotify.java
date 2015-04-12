package threads.concurrency_cookbook.chapter_generic;

/**
 * Created by sharath on 3/27/15.
 */
public class WaitNotify extends Thread {
    private int count;

    public WaitNotify() {
        this.count = 0;
    }

    public void run() {


        System.out.println(count);
    }

    public static void main(String[] args) {
        Thread t1 = new WaitNotify();
        Thread t2 = new WaitNotify();

        t1.start();
        t2.start();
    }
}
