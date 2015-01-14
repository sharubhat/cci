package elements.of.programming.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sharath on 1/9/15.
 *
 * Problem 7.1
 *
 * Merge two sorted linked lists
 */
public class MergeSortedLists_7_1 {

    public static ListNode<Integer> mergeTwoSortedLinkedLists(ListNode<Integer> p1, ListNode<Integer> p2) {
        ListNode<Integer> result = new ListNode<>(0, null);
        ListNode<Integer> curr = result;
        ListNode<Integer> F = p1, L = p2;
        while(F != null && L != null) {
            if(F.data <= L.data) {
                curr.next = F;
                F = F.next;
            }
            else if(F.data > L.data) {
                curr.next = L;
                L = L.next;
            }
            curr = curr.next;
        }
        if(F != null) {
            curr.next = F;
        }
        if(L != null) {
            curr.next = L;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Random ran = new Random();
        for(int times = 0; times < 20; times++) {
            ListNode<Integer> p1 = null;
            ListNode<Integer> p2 = null;
            int n = ran.nextInt(20), m = ran.nextInt(20);
//            System.out.printf("m and n are %d, %d", m, n);
//            System.out.println();
            List<Integer> pl1 = new ArrayList<>();
            List<Integer> pl2 = new ArrayList<>();
            for(int i = 0 ; i < n; i++) {
                pl1.add(ran.nextInt(100));
            }
            for(int i = 0; i < m; i++) {
                pl2.add(ran.nextInt(100));
            }
            Collections.sort(pl1);
            Collections.sort(pl2);
            for(int i = pl1.size(); i > 0; --i) {
                ListNode<Integer> tmp = new ListNode<>(pl1.get(i - 1), null);
                tmp.next = p1;
                p1 = tmp;
            }
            for(int i = pl2.size(); i > 0; --i) {
                ListNode<Integer> tmp = new ListNode<>(pl2.get(i - 1), null);
                tmp.next = p2;
                p2 = tmp;
            }

//            p1.print();
//            p2.print();

            ListNode<Integer> sortedhead = mergeTwoSortedLinkedLists(p1, p2);
//            sortedhead.print();
            int count = 0;
            int pre = Integer.MIN_VALUE;
            while(sortedhead != null) {
                if(pre > sortedhead.data) {
                    System.out.println("Incorrect sorting");
                }
                pre = sortedhead.data;
                sortedhead = sortedhead.next;
                count++;
            }
            if(count != n + m)
                System.out.println("Missed some nodes");
            System.out.println("All is well");
        }
    }
}
