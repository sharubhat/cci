package hackerrank.design_patterns.strategy;

/**
 * Created by sharath on 1/5/16.
 */
public class Bird extends Animal {
    public Bird() {
        super();
        setSound("Tweet");
        flyingType = new ItFlys();
    }
}
