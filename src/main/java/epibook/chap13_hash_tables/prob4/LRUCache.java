package epibook.chap13_hash_tables.prob4;

import epibook.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : This code needs a fix.
 * Created by sharath on 6/29/15.
 */
public class LRUCache {
//    private int lookupVal = 0, capacity;
//    private Map<Integer, Pair<Node, Integer>> isbnPriceTable = new HashMap<>();
//    private Node head = null, end = null;
//
//    class Node<T> {
//        T data;
//        Node<T> pre;
//        Node<T> next;
//
//        public Node(T data) {
//            this.data = data;
//        }
//    }
//
//    private void setHead(Node<Integer> node) {
//        if(head != null) {
//            node.next = head;
//            head.pre = node;
//        }
//        head = node;
//    }
//
//    private void remove(Node<Integer> node) {
//        if(node.pre != null)
//            node.pre.next = node.next;
//        else
//            head = node.next;
//        if(node.next != null)
//            node.next.pre = node.pre;
//    }
//
//    public LRUCache(int i) {
//        this.capacity = i;
//    }
//
//    private boolean lookup(int isbn) {
//        Pair<Node, Integer> p = it.get(isbn);
//        if(p == null) {
//            return false;
//        }
//
//        lookupVal = p.getSecond();
//        moveToFront(isbn, p);
//        return true;
//    }
//
//    private void insert(int isbn, int price) {
//        Pair<Node, Integer> it = isbnPriceTable.get(isbn);
//        if(it != null) {
//            moveToFront(isbn, it);
//        } else {
//            Node<Integer, Integer> created = new Node<>(isbn, price);
//            if(isbnPriceTable.size() >= capacity) {
//
//            } else {
//                lruCache.addFirst(created);
//            }
//        }
//    }
//
//    private void erase(int i) {
//
//    }
//
//    private void moveToFront(Integer isbn, Pair<Node, Integer> p) {
//        remove(p.getFirst());
//        setHead(new Node(isbn));
//        p.setFirst(head);
//    }
//
//    public static void main(String[] args) {
//        LRUCache c = new LRUCache(3);
//        System.out.println("c.insert(1, 1)");
//        c.insert(1, 1);
//        System.out.println("c.insert(1, 10)");
//        c.insert(1, 10);
//
//        if(!c.lookup(2))
//            System.out.println("c.lookup(2, val)");
//
//        if(c.lookup(1))
//            System.out.println("c.lookup(1, val)");
//
//        if(c.lookupVal == 1)
//            System.out.println(c.lookupVal);
//        c.erase(1);
//        if(!c.lookup(1))
//            System.out.println("Erase successful");
//    }
}
