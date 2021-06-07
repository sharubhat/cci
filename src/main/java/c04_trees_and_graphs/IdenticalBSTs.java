package c04_trees_and_graphs;

/**
 *
 * Given 2 arrays.Imagine you are making bst from each array.
 You need to tell whether 2 bsts will be identical or not without actually constructing the tree.
 Ex:
 2 3 1
 2 1 3
 will construct the same tree
 A1[]={2,1,3}
 2
 1 3

 A2[]={2,3,1}
 2
 1 3

 * Created by sharath on 8/14/15.
 */
public class IdenticalBSTs {
    public static boolean isIdentical(int[] a, int[] b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null ^ b == null) {
            return false;
        } else {
            if (a.length != b.length) {
                return false;
            }
            return isIdentical(a, b, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    private static boolean isIdentical(int[] a, int[] b, int ia, int ib, int min, int max) {
        int i, j;
        for (i = ia; i < a.length; i++) {
            if (a[i] > min && a[i] < max) {
                break;
            }
        }

        for (j = ib; j < b.length; j++) {
            if (b[j] > min && b[j] < max) {
                break;
            }
        }

        if (i == a.length && j == b.length) {
            return true;
        } else if (i == a.length ^ j == b.length || a[i] != b[j]) {
            return false;
        } else {
            return isIdentical(a, b, i + 1, j + 1, min, a[i]) &&    // left subtree
                    isIdentical(a, b, i + 1, j + 1, a[i], max);     // right subtree
        }


    }
}
