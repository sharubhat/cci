package threads.concurrency_cookbook.chapter1._12_factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by sharath on 1/31/15.
 */
public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        this.counter = 0;
        this.name = name;
        this.stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Creted thread %d with name %s on %s\n",
                t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStats() {
        StringBuffer sb = new StringBuffer();
        Iterator<String> it = stats.iterator();

        while(it.hasNext()) {
            sb.append(it.next());
            sb.append("\n");
        }
        return sb.toString();
    }
}
