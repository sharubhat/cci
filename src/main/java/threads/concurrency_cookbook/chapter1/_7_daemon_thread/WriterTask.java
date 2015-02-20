package threads.concurrency_cookbook.chapter1._7_daemon_thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Deque;

/**
 * Created by sharath on 1/31/15.
 */
public class WriterTask implements Runnable {
    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setTimestamp(new Date());
            event.setEvent(String.format("The thread %s has generated an event",
                    Thread.currentThread().getId()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
