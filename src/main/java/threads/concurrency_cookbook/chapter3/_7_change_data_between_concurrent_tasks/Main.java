package threads.concurrency_cookbook.chapter3._7_change_data_between_concurrent_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by sharath on 2/6/15.
 */
public class Main {
    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();
        Exchanger<List<String>> exchanger = new Exchanger<>();

        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);

        Thread threadProduer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadProduer.start();
        threadConsumer.start();
    }
}
