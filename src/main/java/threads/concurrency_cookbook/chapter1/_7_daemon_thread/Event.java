package threads.concurrency_cookbook.chapter1._7_daemon_thread;

import java.util.Date;

/**
 * Created by sharath on 1/29/15.
 */
public class Event {
    private Date timestamp;
    private String event;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
