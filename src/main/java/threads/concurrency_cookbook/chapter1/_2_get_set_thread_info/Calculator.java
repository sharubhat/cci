package threads.concurrency_cookbook.chapter1._2_get_set_thread_info;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sharath on 1/29/15.
 */
public class Calculator implements Runnable {
    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 0 ; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",
                    Thread.currentThread().getName(), number, i, number * i);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];
        for(int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if(i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        try(FileWriter file = new FileWriter("src/main/java/threads/_2_get_set_thread_info/data/log.txt");
            PrintWriter pw = new PrintWriter(file)) {
            for(int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            for(Thread t : threads) {
                t.start();
            }

            boolean finish = false;
            while(!finish) {
                for(int i = 0; i < 10; i++) {
                    if(threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                    }
                }
                finish = true;
                for(int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread t, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", t.getId(), t.getName());
        pw.printf("Main : Priority %d\n", t.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", t.getState());
        pw.printf("Main : *******************************************\n");
    }
}
