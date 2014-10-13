package c04_trees_and_graphs.binary_search_tree;

import org.junit.After;
import org.junit.Before;

/**
 * Created by sharath on 8/10/14.
 */
public class TreeNodeTest{
    Node T;
    @Before
    public void setUp() {
        int[] array = {12,14,15,17,18,53,75,100,200};
        T = Node.createMinBST(array);
    }

    public static void main(String[] args) {
        int[] array = {12,14,15,17,18,53,75,100,200};
        Node node = Node.createMinBST(array);

        node.inOrderIterative();
        System.out.println("");
        node.inOrderTraverse();
        System.out.println("");
        System.out.println(node.treeSuccessor());
        System.out.println("Given is tree is " + (node.isBST()? "BST": "not BST" ));
    }

    @After
    public void tearDown() {
        T = null;
    }

}