package threads.concurrency_cookbook.chapter3._7_change_data_between_concurrent_tasks;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by sharath on 2/6/15.
 */
public class Consumer implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;


    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int cycle = 1;
        for(int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Cycle %d\n", cycle);
            System.out.println("Consumer: buffer size before exchange: " + buffer.size());
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: buffer size: " + buffer.size());
            for(int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer: " + message);
                buffer.remove(0);
            }
            cycle++;
        }
    }
}
