package threads.concurrency_cookbook.chapter2._7_multiple_conditions_in_locks;

import java.util.Random;

/**
 * Created by sharath on 2/2/15.
 */
public class Consumer implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
