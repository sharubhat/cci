package c04_trees_and_graphs.binary_search_tree;

/**
 * Created by sharath on 8/23/14.
 */
public class NodeDelete {

    public boolean deleteNode(Node root, int key) {
        Node curr = root;
        Node parent = root;
        boolean isLeftChild = false;

        // case 1: Node to be deleted has no children
        while(curr.data != key) {
            parent = curr;
            if(key < curr.data) {
                isLeftChild = true;
                curr = curr.left;
            } else {
                isLeftChild = false;
                curr = curr.right;
            }
            if(curr == null)
                return false;
        }

        // lets go ahead and delete it for good
        if(curr.left == null && curr.right == null) {
            if(curr == root)
                root = null;
            if(isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }

        // case 2: Node to be deleted has one child
        else if(curr.left == null) {
            if(curr == root)
                root = curr.right;
            if(isLeftChild) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        }

        else if(curr.right == null) {
            if(curr == root)
                root = curr.left;
            if(isLeftChild)
                parent.left = curr.left;
            else
                parent.right = curr.left;
        }

        // case 3: Node to be deleted has two children
        // replace the node with in order successor
        else {
            // get successor of node to delete (current)
            Node successor = getSuccessor(curr);
            // connect parent of current to successor instead
            if(curr == root)
                root = successor;
            if(isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            // connect successor to current node's left child
            successor.left = curr.left;
        }
        return true;
    }

    // returns node with next-highest value after delNode
    // goes to right child, then right child's left descendants
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node curr = delNode.right;
        while(curr != null) {
            successorParent = successor;
            successor = curr;
            curr = curr.left;
        }
        if(successor != delNode.right) {
            // go to right child // until no more
            // left children,
            // go to left child
            // if successor not // right child,
            // make connections
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }
}
