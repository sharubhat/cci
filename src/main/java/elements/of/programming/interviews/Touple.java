package elements.of.programming.interviews;

/**
 * Created by sharath on 1/13/15.
 */
public class Touple<A, B> {
    private A first;
    private B second;

    public Touple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "  " + second + ')';
    }

    public static <T extends Comparable<T>> Touple<T, T> minmax(T a, T b) {
        return b.compareTo(a) < 0 ? new Touple<>(b, a) : new Touple<>(a, b);
    }
}
