package threads.concurrency_cookbook.chapter3._6_overriding_phaser_onadvance;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 2/5/15.
 */
public class Student implements Runnable {
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s: Has arrived to do the exam. %s\n",
                Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to do the first exercise. %s\n",
                Thread.currentThread().getName(), new Date());
        doExercise1();
        System.out.printf("%s: Has done the first exercise. %s\n",
                Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to do the second exercise. %s\n",
                Thread.currentThread().getName(), new Date());
        doExercise2();
        System.out.printf("%s: Has done the Second exercise. %s\n",
                Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to take the exam. %s\n",
                Thread.currentThread().getName(), new Date());
        exam();
        System.out.printf("%s: Has finished the exam. %s\n",
                Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    private void exam() {
        long duration = (long)(Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise2() {
        long duration = (long)(Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise1() {
        long duration = (long)(Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
