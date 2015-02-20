package threads.concurrency_cookbook.chapter5.find_max_in_large_unsorted_array;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created by sharath on 2/8/15.
 */
public class MaxSearchTask extends RecursiveTask<Integer> {
    private int[] numbers;
    private int startIndex;
    private int endIndex;
    private int taskSize = 100_000;

    public MaxSearchTask(int[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public MaxSearchTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.startIndex = start;
        this.endIndex = end;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if(endIndex - startIndex <= taskSize) {
            result = findMax(startIndex, endIndex);
        } else {
            int mid = startIndex + (endIndex - startIndex)/ 2;
            MaxSearchTask leftTask = new MaxSearchTask(numbers, startIndex, mid);
            MaxSearchTask rightTask = new MaxSearchTask(numbers, mid, endIndex);
            invokeAll(leftTask, rightTask);
            try {
                result = Math.max(leftTask.get(), rightTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer findMax(int start, int end) {
        int max = numbers[start];
        for(int i = start; i < end; i++) {
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}
