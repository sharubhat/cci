package hackerrank.concurrency.cci.call_in_order;

/**
 * Created by sharath on 5/25/16.
 */
public class MyThread extends Thread {
    private String method;
    private CallOrder callOrder;

    public MyThread(CallOrder callOrder, String method) {
        this.method = method;
        this.callOrder = callOrder;
    }

    @Override
    public void run() {
        if(method.equals("first"))
            callOrder.first();
        if(method.equals("second"))
            callOrder.second();
        if(method.equals("third"))
            callOrder.third();
    }
}
