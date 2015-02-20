package threads.concurrency_cookbook.chapter1._11_controlling_exception_thread_groups;

import java.util.Random;

/**
 * Created by sharath on 1/31/15.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true) {
            result = 1000/((int)random.nextDouble()*1000);
            System.out.printf("%s : %f\n",
                    Thread.currentThread().getId(), result);
            if(Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n",
                        Thread.currentThread().getId());
                return;
            }
        }
    }
}
