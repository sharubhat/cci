package hackerrank.concurrency.cci.call_in_order;

/**
 * Created by sharath on 5/25/16.
 */
public class QuestionWrong {
    public static void main(String[] args) {
        CallOrderWrong callOrderWrong = new CallOrderWrong();

        MyThreadWrong t1 = new MyThreadWrong(callOrderWrong, "first");
        MyThreadWrong t2 = new MyThreadWrong(callOrderWrong, "second");
        MyThreadWrong t3 = new MyThreadWrong(callOrderWrong, "third");

        t1.start();
        t2.start();
        t3.start();
    }
}
