package threads_book.print_queue_lock;

/**
 * Created by sharath on 3/29/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue));
        }

        for(int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
