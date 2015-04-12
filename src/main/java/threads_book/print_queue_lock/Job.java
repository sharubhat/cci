package threads_book.print_queue_lock;

/**
 * Created by sharath on 3/29/15.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.
                currentThread().getName());
        printQueue.print();
        System.out.printf("%s: The document has been printed\n",
                Thread.currentThread().getName());
    }
}
