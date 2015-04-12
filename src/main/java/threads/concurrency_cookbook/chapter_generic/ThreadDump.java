package threads.concurrency_cookbook.chapter_generic;

import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 3/24/15.
 */
public class ThreadDump implements Runnable {


    public static void main(String[] args) {
        new Thread(new ThreadDump()).start();
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
