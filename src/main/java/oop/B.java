package oop;

/**
 * Created by sharath on 9/17/14.
 */
public class B extends A {
    public int i = 1;

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.printf("a.i = %s and a.getI() = %s%n",
                a.i, a.getI());
        System.out.printf("a.i = %s and ((B)a).i = %s%n",
                a.i, ((B)a).i);
    }
}

//        A a = null;
//        a = new A();
//        change(a);
//        System.out.println(a.i);
//        System.out.println(a.getI());
//    }
//
//    public static void change(A a) {
//        a = new B();
//        System.out.println("Inside");
//        System.out.println(a.i);
//        System.out.println(a.getI());
//        System.out.println("Outside");
//    }
//}
