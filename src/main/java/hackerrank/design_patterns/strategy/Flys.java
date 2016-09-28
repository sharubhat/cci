package hackerrank.design_patterns.strategy;

/**
 * Created by sharath on 1/5/16.
 */

// The interface is implemented by many other
// subclasses that allow for many types of flying
// without effecting Animal, or Flys.

// Classes that implement new Flys interface
// subclasses can allow other classes to use
// that code eliminating code duplication

// I'm decoupling : encapsulating the concept that varies

public interface Flys {
    String fly();
}

// Class used if the Animal can fly
class ItFlys implements Flys {
    @Override
    public String fly() {
        return "Flying high.";
    }
}

// Class used if the Animal can't fly
class CantFly implements Flys {
    @Override
    public String fly() {
        return "I can't fly.";
    }
}


