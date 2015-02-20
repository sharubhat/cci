package threads.concurrency_cookbook.chapter4._1_thread_executor;

/**
 * Created by sharath on 2/6/15.
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        for(int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
