package core;

/**
 * Created by sharath on 3/22/15.
 */
public class InnerClassExample {
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public InnerClassExample() {
        for(int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {
        DataStructureIterator iterator = new EventIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> { }

    private class EventIterator implements DataStructureIterator {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return (nextIndex <= SIZE - 1);
        }

        @Override
        public Integer next() {
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;
            return retValue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    public static void main(String[] args) {
        InnerClassExample ie = new InnerClassExample();
        ie.printEven();
    }
}
