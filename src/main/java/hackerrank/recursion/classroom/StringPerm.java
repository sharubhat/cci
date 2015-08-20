package hackerrank.recursion.classroom;

/**
 * Created by sharath on 8/18/15.
 */
public class StringPerm {
    public static void perm(String str) {
        permR(str.toCharArray(), 0);
    }

    private static void permR(char[] str, int n) {
        if(n == str.length)
            System.out.println(str);
        for(int j = n; j < str.length; j++) {
            swap(str, n, j);
            permR(str, n+1);
            swap(str, j, n);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        perm("bac");
    }
}
