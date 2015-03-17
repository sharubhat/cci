package corejavainterviewquestions;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by sharath on 3/15/15.
 */
public class Queue {
    private Stack stackOne = new Stack();
    private Stack stackTwo = new Stack();

    public void add(String item) {
        stackOne.push(item);
    }

    public String remove() {
        if(stackOne.isEmpty() && stackTwo.isEmpty())
            throw new NoSuchElementException("Empty queue");
        if(stackTwo.isEmpty()) {
            while(!stackOne.isEmpty()) {
                stackTwo.add(stackOne.pop());
            }
        }
        return (String)stackTwo.pop();
    }

    private void swapStacks(Stack from, Stack to) {
        while(!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
