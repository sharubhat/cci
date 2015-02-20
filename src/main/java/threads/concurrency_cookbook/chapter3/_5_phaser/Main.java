package threads.concurrency_cookbook.chapter3._5_phaser;

import java.util.concurrent.Phaser;

/**
 * Created by sharath on 2/4/15.
 */
public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("~/Documents/git/cci", "class", phaser);
        FileSearch apps = new FileSearch("~/Documents/git/cci", "class", phaser);
        FileSearch docs = new FileSearch("~/Documents/git/cci", "class", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread docsThread = new Thread(docs, "Docs");
        docsThread.start();

        try {
            systemThread.join();
            appsThread.join();
            docsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Terminated: " + phaser.isTerminated());
    }
}
