package threads.concurrency_cookbook.chapter1._11_controlling_exception_thread_groups;

/**
 * Created by sharath on 1/31/15.
 */
public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an exception \n", t.getId());
        e.printStackTrace();
        System.out.printf("Terminating the rest of the threads\n");
        interrupt();
    }
}
