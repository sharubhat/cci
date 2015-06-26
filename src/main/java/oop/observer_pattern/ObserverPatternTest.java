package oop.observer_pattern;

/**
 * Created by sharath on 4/30/15.
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();

        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        obj1.setSubect(topic);
        obj2.setSubect(topic);
        obj3.setSubect(topic);

        obj1.update();

        topic.postMessage("New Message");
    }
}
