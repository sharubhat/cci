package hackerrank.design_patterns.observer;

/**
 * Created by sharath on 1/6/16.
 */
public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();
}
