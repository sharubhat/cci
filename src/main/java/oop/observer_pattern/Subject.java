package oop.observer_pattern;

/**
 * Created by sharath on 4/30/15.
 */
public interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);

    void notifyObservers();

    Object getUpdate(Observer obj);
}
