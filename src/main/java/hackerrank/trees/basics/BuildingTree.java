package hackerrank.trees.basics;

public class BuildingTree {
    /**
     * Building tree from inorder and postorder traversal.
     */
    public Node buildTreeInPost(int[] inorder, int[] postorder) {
        return buildTreeInPost(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private Node buildTreeInPost(int[] postorder, int pos, int[] inorder, int ios, int ioe) {
        if (pos < 0 || ios > ioe) {
            return null;
        }
        // find index of postorder[pos] in inorder[]
        int target = ios;
        while (inorder[target] != postorder[pos]) {
            target++;
        }
        Node root = new Node(postorder[pos]);
        root.left = buildTreeInPost(postorder, pos - ioe + target -1, inorder, ios, target - 1);
        root.right = buildTreeInPost(postorder, pos - 1, inorder, target + 1, ioe);
        return root;
    }

    /**
     * Building tree from inorder and preorder traversal.
     */
    private Node buildTreeInPre(int[] inorder, int[] preorder) {
        return buildTreeInPre(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private Node buildTreeInPre(int[] preorder, int pos, int[] inorder, int ios, int ioe) {
        if (pos > preorder.length - 1 || ios > ioe) {
            return null;
        }
        // find index of preorder[pos] in inorder[]
        int target = ios;
        while (inorder[target] != preorder[pos]) {
            target++;
        }
        Node root = new Node(preorder[pos]);
        root.left = buildTreeInPre(preorder, pos + 1, inorder, ios, target - 1);
        root.right = buildTreeInPre(preorder, pos + target - ios + 1, inorder, target + 1, ioe);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {25, 15, 10, 20, 35, 30, 27, 40};
        int[] in =  {10, 15, 20, 25, 27, 30, 35, 40};
        int[] post = {10, 20, 15, 27, 30, 40, 35, 25};

        Node root = new BuildingTree().buildTreeInPost(in, post);
        Traversals.inOrder(root);
        Traversals.levelOrder(root);

        root = new BuildingTree().buildTreeInPre(in, pre);
        Traversals.inOrder(root);
        Traversals.levelOrder(root);
    }
}
