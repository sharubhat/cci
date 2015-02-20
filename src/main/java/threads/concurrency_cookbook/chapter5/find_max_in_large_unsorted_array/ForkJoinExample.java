package threads.concurrency_cookbook.chapter5.find_max_in_large_unsorted_array;

import java.security.SecureRandom;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 2/8/15.
 */
public class ForkJoinExample {
    // java.util.Random generates random values which are a linear congruential pseudorandom numbers.
    // These are easily predictable. java.security.SecureRandom generates numbers that are hard to predict.
    // However, when these random numbers are not used for any security reasons, java.util.Random is faster.
    private static final SecureRandom RANDOM = new SecureRandom();

    public static int[] generateNumbers(int size) {
        int[] nums = new int[size];
        for(int i = 0; i < size; i++) {
            nums[i] = RANDOM.nextInt(Integer.MAX_VALUE);
        }
        return nums;
    }

    private static int findMax(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void printTimeTaken(String caption, long startTime) {
        System.out.printf("Time taken for %s is %d milliseconds\n", caption, System.currentTimeMillis() - startTime);
    }

    public static void main(String[] args) {
        // finding max in array of 200 million entries
        int size = 100_000_000;

        long startTime = System.currentTimeMillis();
        int[] nums = generateNumbers(size);
        printTimeTaken("Generating numbers", startTime);

        startTime = System.currentTimeMillis();
        int m = findMax(nums);
        printTimeTaken("Finding max in single thread", startTime);
        System.out.printf("Max number found is %d\n", m);

        MaxSearchTask task = new MaxSearchTask(nums);
        ForkJoinPool pool = new ForkJoinPool();
        startTime = System.currentTimeMillis();
        pool.execute(task);
        do {

        } while(!task.isDone());
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.printf("Main: Max number found is %d\n", task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        printTimeTaken("Finding max using fork/join", startTime);
    }
}
