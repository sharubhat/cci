package hackerrank.trees.others;

/**
 * Find all paths in a binary tree that sums to given number. The path need not always start from root and end in a leaf.		- Hortonworks
                    100
              /	            \
            5			       8
         /    \             /     \
      -1	   2	      -2		2
     /				       \       /
   1				        -3	  -4
                           /
                          3

 Sum = 6
 Sol:
 {5, 2}
 {8, -2}
 {8, -2, -3, 3}
 {8,2,-4}
 * Created by sharath on 10/15/15.
 */
public class PathsWithSum {
    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node r = new Node(100);
        r.left = new Node(5);
        r.right = new Node(8);

    }
}
