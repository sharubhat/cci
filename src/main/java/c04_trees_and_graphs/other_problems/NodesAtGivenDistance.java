package c04_trees_and_graphs.other_problems;

import java.util.*;

/**
 * For the given graph, there is a bug (root, 12, 1)
 * Created by sharath on 9/8/14.
 */
public class NodesAtGivenDistance {

    class Node {
        int data;
        Node parent;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }

        public Node getNode(int data) {
            return getNode(this, data);
        }
        private Node getNode(Node root, int data) {
            if(root.data == data)
                return root;
            if(root.left != null) {
                return getNode(root.left, data);
            }
            if(root.right != null) {
                return getNode(root.right, data);
            }
            return null;
        }
    }
    class Tree {

        Node root;
        public Tree() {
            root = null;
        }

        public Node addNode(Node n, Node parent, boolean isLeftChild) {
            if(root == null)
                root = n;
            else {
                if(isLeftChild) {
                    parent.left = n;
                } else {
                    parent.right = n;
                }
                n.parent = parent;
            }
            return n;
        }

    }

    public static void main(String[] args) {
        // read the input from the file
        NodesAtGivenDistance test = new NodesAtGivenDistance();
        Tree tree = test.createTree();

        List<Integer> result = test.F(tree.root, 13, 1);
        for(int i : result) {
            System.out.print(i + ", ");
        }
    }
    public List<Integer> F(Node root, int g, int dist) {
        Node given = bfs(root, g);
        List<Integer> result = new ArrayList<>();
        Node tmp = given;
        int parentIndex = dist;
        while(tmp != null && parentIndex != 0) {
            tmp = tmp.parent;
            parentIndex--;
        }
        if(tmp != null)
            result.add(tmp.data);
        levelOrderTraverse(result, given, dist);
        return result;
    }

    private Node bfs(Node root, int data) {
        if(root.data == data)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node current = q.remove();
            if(current.data == data)
                return current;
            if(current.left != null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
        }
        return null;
    }

    private List<Integer> levelOrderTraverse(List<Integer> result, Node given, int dist) {
        Queue<Node> q = new LinkedList<>();
        q.add(given);
        while(!q.isEmpty() && dist != -1) {
            Node current = q.remove();
            if(current.left != null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
            dist--;
        }
        Iterator<Node> it = q.iterator();
        while(it.hasNext()) {
            result.add(it.next().data);
        }
        return result;
    }

    private Tree createTree(){
        Tree tree = new Tree();
        Node n5 = tree.addNode(new Node(5), null, false);
        Node n8 = tree.addNode(new Node(8), n5, true);
        Node n1 = tree.addNode(new Node(1), n8, true);
        Node n9 = tree.addNode(new Node(9), n8, false);
        Node n12 = tree.addNode(new Node(12), n1, true);
        Node n13 = tree.addNode(new Node(13), n1, false);
        Node n14 = tree.addNode(new Node(14), n9, true);
        Node n16 = tree.addNode(new Node(16), n12, true);
        Node n17 = tree.addNode(new Node(17), n12, false);
        return tree;
    }

}
