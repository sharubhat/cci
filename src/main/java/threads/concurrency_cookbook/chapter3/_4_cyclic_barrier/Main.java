package threads.concurrency_cookbook.chapter3._4_cyclic_barrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by sharath on 2/4/15.
 */
public class Main {
    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT = 2000;

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Result result = new Result(ROWS);
        Grouper grouper = new Grouper(result);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        Searcher[] searchers = new Searcher[PARTICIPANTS];
        for(int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i*LINES_PARTICIPANT,
                    (i* LINES_PARTICIPANT + LINES_PARTICIPANT),
                    mock,
                    result,
                    5,
                    barrier);
            Thread t = new Thread(searchers[i]);
            t.start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }
}
