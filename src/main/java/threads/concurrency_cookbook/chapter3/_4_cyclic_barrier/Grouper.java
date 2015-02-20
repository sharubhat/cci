package threads.concurrency_cookbook.chapter3._4_cyclic_barrier;

/**
 * Created by sharath on 2/4/15.
 */
public class Grouper implements Runnable {
    private Result result;

    public Grouper(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        int data[] = result.getData();
        for(int n : data) {
            finalResult += n;
        }
        System.out.printf("Grouper: total result: %d.\n", finalResult);
    }
}
