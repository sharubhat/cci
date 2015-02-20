package threads.concurrency_cookbook.chapter1._5_sleep_resume;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 1/29/15.
 */
public class FileClock implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The file clock has been interrupted\n");
            }
        }
    }

    public static void main(String[] args) {
        FileClock clock =new FileClock();
        Thread t = new Thread(clock);
        t.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
