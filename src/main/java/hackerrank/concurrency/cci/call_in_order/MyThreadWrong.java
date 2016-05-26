package hackerrank.concurrency.cci.call_in_order;

/**
 * Created by sharath on 5/25/16.
 */
public class MyThreadWrong extends Thread {
    private String method;
    private CallOrderWrong callOrderWrong;

    public MyThreadWrong(CallOrderWrong callOrder, String method) {
        this.method = method;
        this.callOrderWrong = callOrder;
    }

    @Override
    public void run() {
        if(method.equals("first"))
            callOrderWrong.first();
        if(method.equals("second"))
            callOrderWrong.second();
        if(method.equals("third"))
            callOrderWrong.third();
    }
}
