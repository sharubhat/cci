package threads.concurrency_cookbook.chapter1._7_daemon_thread;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by sharath on 1/31/15.
 */
public class Main {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();
        WriterTask writer = new WriterTask(deque);
        for(int i = 0; i < 3; i++) {
            Thread t = new Thread(writer);
            t.start();
        }
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
