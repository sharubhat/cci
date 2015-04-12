package core;

import java.util.Arrays;

/**
 * Created by sharath on 3/21/15.
 */


/**
 * Questions
 *
 * The term "instance variable" is another name for ___. Ans: non-static field
 * The term "class variable" is another name for ___. Ans: static field
 * A local variable stores temporary state; it is declared inside a ___. Ans: method
 * A variable declared within the opening and closing parenthesis of a method signature is called a ____. Ans: parameter
 * What are the eight primitive data types supported by the Java programming language?
 * Ans: byte, short, char, int, float, long, double, and boolean
 * Character strings are represented by the class ___. Ans: java.lang.String
 * An ___ is a container object that holds a fixed number of values of a single type. Ans: array
 *
 */
public class ArrayCopy {
    public static void main(String[] args) {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        // copyRange from Arrays utility class does not require creation of new copyTo array.
        // Signature: public static char[] copyOfRange(char[] original, int from, int to)
        char[] copyTo = Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));

        char[] copyTo2 = new char[7];

        // arrayCopy from System class requires destination array to be present at time of copy
        // Error prone approach. It could throw ArrayIndexOutOfBoundsException.
        // Signature:
        //        public static native void arraycopy(Object src,  int  srcPos,
        //        Object dest, int destPos,
        //        int length)
        System.arraycopy(copyFrom, 2, copyTo2, 0, 7);

        System.out.println(new String(copyTo2));


        // Array also supports sort(), binarySearch() on sorted array, parallelSort() as of java 8,
        // fill() which can fill each element of the array with default value
    }
}
