package hackerrank.list_stack_queues.homework;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Zip a linkedlist from two ends.
 * 1->2->3->4->5->6
 * Result 1->6->2->5->3->4
 * Created by sharath on 8/19/15.
 */
public class Zip {
    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, int val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }

    static LinkedListNode Zip(LinkedListNode pList) {
        LinkedListNode slow = pList;
        LinkedListNode fast = pList;

        while(pList != null && pList.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        reverse(slow);

        return null;
    }

    static LinkedListNode reverse(LinkedListNode pList) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        LinkedListNode res;

        int _pList_size = Integer.parseInt(in.nextLine()), _pList_i;
        int _pList_item;
        LinkedListNode _pList = null;
        for(_pList_i = 0; _pList_i < _pList_size; _pList_i++) {
            _pList_item = Integer.parseInt(in.nextLine());
            _pList = _insert_node_into_singlylinkedlist(_pList, _pList_item);
        }

        res = Zip(_pList);
        while (res != null) {
            bw.write(String.valueOf(res.val));
            bw.newLine();
            res = res.next;
        }

        bw.close();
    }
}
