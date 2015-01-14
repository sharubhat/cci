package others;

/**
 * Created by sharath on 10/28/14.
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        pt.printLine(6);
        pt.printNLines(6);
    }

    private void printLine(int n) {
        if (n < 0)
            return;
        int m = 1;
        System.out.print("1 ");
        for (int i = 1; i < n; i++) {
            m = m * (n - i) / i;
            System.out.print(m + " ");
        }
        System.out.println();
    }

    private void printNLines(int n) {
        for(int i = 1; i <= n; i++) {
            printLine(i);
        }
    }
}
