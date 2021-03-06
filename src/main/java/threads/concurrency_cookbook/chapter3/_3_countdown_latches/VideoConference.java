package threads.concurrency_cookbook.chapter3._3_countdown_latches;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sharath on 2/3/15.
 */
public class VideoConference implements Runnable{
    private final CountDownLatch controller;

    public VideoConference(int num) {
        this.controller = new CountDownLatch(num);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n",
                controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n",
                controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
