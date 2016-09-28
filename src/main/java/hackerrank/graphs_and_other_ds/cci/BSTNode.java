package hackerrank.graphs_and_other_ds.cci;

/**
 * Created by sharath on 5/30/16.
 */
public class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int data) {
        this.data = data;
    }

    public BSTNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public static BSTNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static BSTNode createMinimalBST(int arr[], int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        BSTNode n = new BSTNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}
