package threads.concurrency_cookbook.chapter4._1_thread_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by sharath on 2/6/15.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);

        System.out.printf("Server: Pool size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
