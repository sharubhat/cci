package threads.concurrency_cookbook.chapter3._3_countdown_latches;

/**
 * Created by sharath on 2/3/15.
 */
public class Main {
    public static void main(String[] args) {
        VideoConference vc = new VideoConference(10);
        Thread tConf = new Thread(vc);
        tConf.start();

        for(int i = 0; i < 10; i++) {
            new Thread(new Participant(vc, "Participant " + i)).start();
        }
    }
}
