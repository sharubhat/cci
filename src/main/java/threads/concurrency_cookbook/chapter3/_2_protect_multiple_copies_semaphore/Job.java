package threads.concurrency_cookbook.chapter3._2_protect_multiple_copies_semaphore;

/**
 * Created by sharath on 2/2/15.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n",
                Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",
                Thread.currentThread().getName());
    }
}
