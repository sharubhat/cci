package threads.concurrency_cookbook.chapter5._1_creating_fork_join_pool;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 2/7/15.
 */
public class Main {
    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(10000);

        Task task = new Task(products, 0, products.size(), 0.2);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.getPoolSize());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while(!task.isDone());

        pool.shutdown();

        if(task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally\n");
        }

        for(Product p: products) {
            if(p.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", p.getName(), p.getPrice());
            }
        }

        System.out.printf("Main: End of the program\n");
    }
}
