package hackerrank.design_patterns.observer;

/**
 * Created by sharath on 1/7/16.
 */
public class GrabStock {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver stockObserver1 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setAaplPrice(106.00);
        stockGrabber.setGoogPrice(675.00);

        StockObserver stockObserver2 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(200.00);
        stockGrabber.setAaplPrice(110.00);
        stockGrabber.setGoogPrice(670.00);

        stockGrabber.unregister(stockObserver1);
        stockGrabber.setIbmPrice(201.00);
        stockGrabber.setAaplPrice(111.00);
        stockGrabber.setGoogPrice(669.00);
    }
}
