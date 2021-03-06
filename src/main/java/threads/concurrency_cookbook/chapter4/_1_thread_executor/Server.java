package threads.concurrency_cookbook.chapter4._1_thread_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Server creates a cached thread pool. When a new task is handed to the server, it either picks available
 * thread from the pool or creates a new one to execute the task. You risk overloading the system if too many tasks
 * are fed too quickly.
 *
 * All that server does is to execute the task and print thread pool statistics.
 *
 * Created by sharath on 2/6/15.
 */
public class Server {
    private final ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(Task task) {
        System.out.println("Server: new task has arrived");
        executor.execute(task);
        System.out.println("Server: Pool size : " + executor.getPoolSize());
        System.out.println("Server: Active count : " + executor.getActiveCount());
        System.out.println("Server: Completed tasks : " + executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
