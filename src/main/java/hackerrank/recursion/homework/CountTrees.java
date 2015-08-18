package hackerrank.recursion.homework;

/**
 * Write a function that will return the number of binary trees that can be constructed, with 'n' nodes.
 *
 * e.g:
 * for n = 1 ==> 1 (just root)
 * for n = 2 ==> 2 (1. root->right 2. root->left)
 * for n = 3 ==> 5 (1. root->right->right 2. root->right->left 3. root->left->left
 *                  4. root->left->right 5. root->left->right
 *
 * The series is called Catalan numbers. There is a standard formula. However solve this problem recursively.
 *
 * Catalan number Cn = (2n)!/(n+1)!*n!
 *
 * ref: http://techieme.in/count-binary-search-trees/
 * ref: http://www.geeksforgeeks.org/program-nth-catalan-number/
 *
 * Created by sharath on 8/15/15.
 */
public class CountTrees {
    public static long numTrees(int n) {
        if(n <= 1)
            return 1;
        long sum = 0;
        for(int i = 0; i < n ; i++) {
            // if there are i nodes to left, then there should be (n-1)-i nodes to right.
            long left = numTrees(i);
            long right = numTrees((n - 1) - i);
            sum += left * right;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("1 ->" + numTrees(1) + " == 1");
        System.out.println("2 ->" + numTrees(2) + " == 2");
        System.out.println("3 ->" + numTrees(3) + " == 5");
        System.out.println("4 ->" + numTrees(4) + " == 14");
        System.out.println("5 ->" + numTrees(5) + " == 42");
        System.out.println("6 ->" + numTrees(6) + " == 132");
    }
}
