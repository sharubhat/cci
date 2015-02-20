package c04_trees_and_graphs.trees.bst_generic;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by sharath on 1/15/15.
 * <p/>
 * BST implementation assumes duplicates are not allowed.
 * So, on insert, if the entry is already present, it will not be added to the tree.
 * This also serves as an example of Builder pattern.
 * It uses a builder to build a tree with a root, and
 * either left and right children or left and right trees or any combination of them.
 */
public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryTree<E>
        implements SearchTree<E> {

    protected static class BSTBuilder<E extends Comparable<E>> {
        private Node<E> root;
        private Node<E> leftNode;
        private Node<E> rightNode;
        private BinarySearchTree<E> leftTree;
        private BinarySearchTree<E> rightTree;

        public BSTBuilder<E> addRoot(E data) {
            this.root = new Node(data);
            return this;
        }

        public BSTBuilder<E> addLeft(E data) {
            this.leftNode = new Node(data);
            return this;
        }

        public BSTBuilder<E> addRight(E data) {
            this.rightNode = new Node<>(data);
            return this;
        }

        public BSTBuilder<E> addLeftTree(BinarySearchTree<E> tree) {
            this.leftTree = tree;
            return this;
        }

        public BSTBuilder<E> addRightTree(BinarySearchTree<E> tree) {
            this.rightTree = tree;
            return this;
        }

        public BinarySearchTree<E> build() {
            return new BinarySearchTree<>(this);
        }
    }

    public BinarySearchTree(BSTBuilder<E> builder) {
        this.root = builder.root;
        if (builder.leftNode != null)
            this.root.setLeft(builder.leftNode);
        if (builder.rightNode != null)
            this.root.setRight(builder.rightNode);
        if (builder.leftTree != null)
            this.root.setLeft(builder.leftTree.root);
        if (builder.rightTree != null)
            this.root.setRight(builder.rightTree.root);
    }

    /**
     * Adds the item if not already in tree. Replaces the item if already present.
     * This constraint is useful when using tree to build a map.
     * @param item
     */
    @Override
    public void add(E item) {
        add(this.root, new Node<>(item));
    }

    private Node<E> add(Node<E> currentParent, Node<E> item) {
        if (currentParent == null) {
            return item;
        }
        int compareResult = item.getData().compareTo(currentParent.getData());
        Node<E> added;
        if (compareResult < 0) {
            // Note, we could always assign return value of add to currentParent's left.
            // But that would be unnecessary as it's simple replacing of current node with same node.
            added = add(currentParent.getLeft(), item);
            if(currentParent.getLeft() == null)
                currentParent.setLeft(added);
        } else if (compareResult > 0) {
            added = add(currentParent.getRight(), item);
            if(currentParent.getRight() == null)
                currentParent.setRight(added);
        } else {
            currentParent.setData(item.getData());
        }
        return currentParent;
    }

    @Override
    public boolean contains(E target) {
        return false;
    }

    @Override
    public E find(E target) {
        return find(root, target);
    }

    private E find(Node<E> root, E target) {
        if (root == null)
            return null;
        int compareResult = target.compareTo(root.getData());
        if (compareResult == 0)
            return root.getData();
        else if (compareResult < 0)
            return find(root.getLeft(), target);
        else
            return find(root.getRight(), target);
    }

    /**
     * if the root is null
     * the item is not in the tree - return null
     * Compare the item to the data in the local root
     * if the item is less than data at the local root
     * Return the result of deleting from left subtree
     * else if the item is greater than data at local root
     * Return the result of deleting form the right subtree
     * else // The item is in the local root
     * Store the data in the local root in deleteReturn
     * if the local root has no children
     * Set the parent of the local root to reference to null
     * else if the local root has one child
     * Set the parent of local root to reference of the child
     * else // (it has both left and right child) Find the inorder predecessor
     * // Note that you never have to consider the right subtree
     * if the left child has no right child, it is the inorder predecessor
     * set the parent of local root to reference the left child
     * else
     * Find the rightmost node in right subtree of the left child
     * Copy it's data into the local root's data and remove it by
     * setting it's parent to reference it's left child
     *
     * @param target
     * @return
     */
    @Override
    public E delete(E target) {
        E deleteReturn = null;
        delete(this.root, target, deleteReturn);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> currentParent, E target, E deleteReturn) {
        if (currentParent == null) {
            return null;
        }
        int compareResult = target.compareTo(currentParent.getData());
        if (compareResult < 0) {
            currentParent.setLeft(delete(currentParent.getLeft(), target, deleteReturn));
            return currentParent;
        } else if (compareResult > 0) {
            currentParent.setRight(delete(currentParent.getRight(), target, deleteReturn));
            return currentParent;
        } else {
            deleteReturn = currentParent.getData();
            if (currentParent.getLeft() == null)
                return currentParent.getRight();
            else if (currentParent.getRight() == null)
                return currentParent.getLeft();
            // Node being deleted has 2 children
            // replace the data with inorder predecessor
            else {
                if(currentParent.getLeft().getRight() == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the left child
                    currentParent.setData(currentParent.getLeft().getData());
                    // Replace the left child with it's left child
                    currentParent.setLeft(currentParent.getLeft().getLeft());
                    return currentParent;
                } else {
                    // search for the inorder processor(ip) and replace the deleted node's data with ip.
                    currentParent.setData(findLargestChild(currentParent.getLeft()));
                    return currentParent;
                }
            }
        }
    }

    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, then it's inorder processor
        if(parent.getRight().getRight() == null) {
            E returnValue = parent.getRight().getData();
            parent.setRight(parent.getRight().getLeft());
            return returnValue;
        } else  {
            return findLargestChild(parent.getRight());
        }
    }

    public E findNextLargest(E data) {
        Node<E> max = findNL(this.root, null, data);
        if(max == null)
            throw new NoSuchElementException("There is no node larger than " + data.toString());
        return max.getData();
    }

    private Node<E> findNL(Node<E> curr, Node<E> max, E data) {
        // you have hit the dead end, go back!
        if(curr == null)
            return max;
        int compareResult = data.compareTo(curr.getData());

        if(compareResult < 0) {
            // if data is lesser, max is curr or some child in left subtree
            // so update max and continue searching
            max = curr;
            return findNL(curr.getLeft(), max, data);
        } else {
            // if data is equal or greater, search the right subtree
            return findNL(curr.getRight(), max, data);
        }
    }

    @Override
    public boolean remove(E target) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOderTraversal(root, sb);
//        sb.append("\n");
//        preOrderTraversal(root, sb);
        return sb.toString();
    }

    private void inOderTraversal(Node<E> node, StringBuilder sb) {
        if(node != null) {
            if(node.getLeft() != null)
                inOderTraversal(node.getLeft(), sb);
            sb.append(node.getData()).append(" ");
            if(node.getData() != null)
                inOderTraversal(node.getRight(), sb);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<String> left = new BinarySearchTree.BSTBuilder().addRoot("and").addLeft("all").addRight("ate").build();
        BinarySearchTree<String> right = new BinarySearchTree.BSTBuilder().addRoot("cock").addLeft("cat").addRight("corn").build();
        BinarySearchTree<String> root1 = new BinarySearchTree.BSTBuilder().addRoot("built").addLeftTree(left).addRightTree(right).build();

        left = new BinarySearchTree.BSTBuilder().addRoot("crumpled").addLeft("crowned").build();
        right = new BinarySearchTree.BSTBuilder().addRoot("forlorn").addLeft("farmer").addRight("horn").build();
        BinarySearchTree<String> root2 = new BinarySearchTree.BSTBuilder().addRoot("dog").addLeftTree(left).addRightTree(right).build();

        BinarySearchTree<String> root3 = new BinarySearchTree.BSTBuilder().addRoot("cow").addLeftTree(root1).addRightTree(root2).build();

        ////////////////////////////////////////

        root1 = new BinarySearchTree.BSTBuilder().addRoot("is").addLeft("in").build();

        left = new BinarySearchTree.BSTBuilder().addRoot("kept").addLeft("jill").build();
        root2 = new BinarySearchTree.BSTBuilder().addRoot("killed").addLeftTree(left).addRight("kissed").build();

        BinarySearchTree<String> root4 = new BinarySearchTree.BSTBuilder().addRoot("jack").addLeftTree(root1).addRightTree(root2).build();

        BinarySearchTree<String> parent1 = new BinarySearchTree.BSTBuilder().addRoot("house").addLeftTree(root3).addRightTree(root4).build();

        ////////////////////////////////////////

        right = new BinarySearchTree.BSTBuilder().addRoot("man").addRight("married").build();
        root1 = new BinarySearchTree.BSTBuilder().addRoot("malt").addLeft("maiden").addRightTree(right).build();

        root2 = new BinarySearchTree.BSTBuilder().addRoot("priest").addLeft("morn").build();

        root3 = new BinarySearchTree.BSTBuilder().addRoot("milked").addLeftTree(root1).addRightTree(root2).build();

        ////////////////////////////////////////

        right = new BinarySearchTree.BSTBuilder().addRoot("tattered").addLeft("sowing").build();
        root1 = new BinarySearchTree.BSTBuilder().addRoot("shorn").addLeft("shaven").addRightTree(right).build();

        left = new BinarySearchTree.BSTBuilder().addRoot("this").addLeft("the").addRight("torn").build();
        right = new BinarySearchTree.BSTBuilder().addRoot("with").addLeft("walked").addRight("worried").build();
        root2 = new BinarySearchTree.BSTBuilder().addRoot("tossed").addLeftTree(left).addRightTree(right).build();


        root4 = new BinarySearchTree.BSTBuilder().addRoot("that").addLeftTree(root1).addRightTree(root2).build();

        BinarySearchTree<String> parent2 = new BinarySearchTree.BSTBuilder().addRoot("rat").addLeftTree(root3).addRightTree(root4).build();

        BinarySearchTree<String> superparent = new BinarySearchTree.BSTBuilder().addRoot("lay").addLeftTree(parent1).addRightTree(parent2).build();

        superparent.add("maven");

        superparent.add("the");

        String result = superparent.toString();

        String[] words = result.split(" ");

        Arrays.sort(words);
        System.out.println(Arrays.equals(words, result.split(" ")));
        System.out.println(superparent.toString());

        System.out.println(superparent.delete("rat"));

        System.out.println(superparent.toString());



        // Finding the next largest number give the root

        BinarySearchTree<Integer> rst = new BinarySearchTree.BSTBuilder().addRoot(7).addLeft(5).addRight(9).build();
        BinarySearchTree<Integer> lst = new BinarySearchTree.BSTBuilder().addRoot(3).addLeft(1).addRightTree(rst).build();
        BinarySearchTree<Integer> secondLST = new BinarySearchTree.BSTBuilder().addRoot(17).addLeft(15).build();
        BinarySearchTree<Integer> secondRST = new BinarySearchTree.BSTBuilder().addRoot(13).addRightTree(secondLST).build();

        BinarySearchTree<Integer> finalTree = new BinarySearchTree.BSTBuilder().addRoot(11).addLeftTree(lst).addRightTree(secondRST).build();

        System.out.println(finalTree);

        for(int i = -1; i < 18; i++) {
            System.out.println("Next largest of " + i + " is " + finalTree.findNextLargest(i));
        }
    }

}
