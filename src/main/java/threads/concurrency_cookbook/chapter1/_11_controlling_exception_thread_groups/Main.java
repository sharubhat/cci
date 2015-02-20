package threads.concurrency_cookbook.chapter1._11_controlling_exception_thread_groups;

/**
 * Created by sharath on 1/31/15.
 */
public class Main {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for(int i=0; i<2; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }
}
