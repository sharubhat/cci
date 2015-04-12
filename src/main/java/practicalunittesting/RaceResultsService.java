package practicalunittesting;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by sharath on 4/9/15.
 */
public class RaceResultsService {
    private Collection<Subscriber> subscribers;

    public RaceResultsService() {
        subscribers = new HashSet<>();
    }

    public void register(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void send(Message message) {
        for(Subscriber s : subscribers) {
            s.receive(message);
        }
    }

    public void deregister(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
}
