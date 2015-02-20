package threads.concurrency_cookbook.chapter3._6_overriding_phaser_onadvance;

import java.util.concurrent.Phaser;

/**
 * Created by sharath on 2/5/15.
 */
public class MyPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch(phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    private boolean finishExam() {
        System.out.println("Phaser: All the students have finished the exam.");
        System.out.println("Phaser: Thank you for your time.");
        return false;
    }

    private boolean finishSecondExercise() {
        System.out.println("Phaser: All the students have finished the second exercise.");
        System.out.println("Phaser: It's time for the exam.");
        return false;
    }

    private boolean finishFirstExercise() {
        System.out.println("Phaser: All the students have finished the first exercise.");
        System.out.println("Phaser: It's time for the second one.");
        return false;
    }

    private boolean studentsArrived() {
        System.out.printf("Phaser: The exams are going to start. The students are ready\n");
        System.out.printf("Phaser: We have %d students\n", getRegisteredParties());
        return false;
    }
}
