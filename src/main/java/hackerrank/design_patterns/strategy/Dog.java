package hackerrank.design_patterns.strategy;

/**
 * Created by sharath on 1/5/16.
 */
public class Dog extends Animal {
    public Dog() {
        super();
        setSound("Bark");
        flyingType = new CantFly();
    }
}
