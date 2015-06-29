package epibook.chap15_BST.prob3;

import epibook.chap15_BST.BinaryTreePrototypeTemplate.BTNode;

/**
 * Time complexity is O(h) where h is height of the tree.
 *
 * This problem can be simply solved using inorder search. But that results in O(n) solution.
 * Making use of the property of BST fastens the search.
 *
 * Created by sharath on 6/29/15.
 */
public class SearchBSTFirstLargerK {

    public static BTNode<Integer> findFirstGreaterThanK(BTNode<Integer> tree,
                                                         Integer k) {
        BTNode<Integer> subtree = tree, greaterSoFar = null;
        while(subtree != null) {
            if(subtree.getData() > k) {
                greaterSoFar = subtree;
                subtree = subtree.getLeft();
            } else {
                subtree = subtree.getRight();
            }
        }
        return greaterSoFar;
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 7
        BTNode<Integer> tree = new BTNode<>(3);
        tree.setLeft(new BTNode<>(2));
        tree.getLeft().setLeft(new BTNode<>(1));
        tree.setRight(new BTNode<>(5));
        tree.getRight().setLeft(new BTNode<>(4));
        tree.getRight().setRight(new BTNode<>(7));
        System.out.println((findFirstGreaterThanK(tree, 1) == tree.getLeft()));
        System.out.println((findFirstGreaterThanK(tree, 5) == tree.getRight().getRight()));
        System.out.println((findFirstGreaterThanK(tree, 6) == tree.getRight().getRight()));
        System.out.println((findFirstGreaterThanK(tree, 7) == null));
    }
}
