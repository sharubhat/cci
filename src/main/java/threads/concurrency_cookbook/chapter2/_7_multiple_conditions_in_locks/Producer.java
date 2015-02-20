package threads.concurrency_cookbook.chapter2._7_multiple_conditions_in_locks;

/**
 * Created by sharath on 2/2/15.
 */
public class Producer implements Runnable {
    private FileMock mock;
    private Buffer buffer;

    public Producer(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while(mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
