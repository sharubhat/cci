package hackerrank.list_stack_queues.epi;

import java.util.Random;

/**
 * Created by sharath on 8/25/15.
 */
public class CopyAPostingList {
    private static class PNode<E> {
        E data;
        PNode<E> next;
        PNode<E> jump;

        public PNode(E e, PNode<E> n, PNode<E> j) {
            this.data = e;
            this.next = n;
            this.jump = j;
        }
    }

    private static <T> PNode<T> copyPostingsList(PNode<T> L) {
        if(L == null)
            return null;

        // make copies ignoring jump links. this breaks original list
        PNode<T> iter = L;
        while(iter != null) {
            PNode<T> newNode = new PNode<>(iter.data, iter.next, null);
            iter.next = newNode;
            iter = newNode.next;
        }

        // assign jump pointers
        iter = L;
        while (iter != null) {
            if(iter.jump != null) {
                iter.next.jump = iter.jump.next;
            }
            iter = iter.next.next;
        }

        // now break the list into two
        iter = L;
        PNode<T> newhead = iter.next;
        while(iter.next != null) {
            PNode<T> temp = iter.next;
            iter.next = temp.next;
            iter = temp;
        }
        return newhead;
    }

    public static void main(String[] args) {
        Random gen = new Random();
        for (int times = 0; times < 1000; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.parseInt(args[0]);
            } else {
                n = gen.nextInt(1000) + 1;
            }

            PNode<Integer> L = null;
            PNode<Integer> curr = L;
            for (int i = 0; i < n; ++i) {
                PNode<Integer> temp = new PNode<>(i, null, null);
                if (L != null) {
                    curr.next = temp;
                    curr = temp;
                } else {
                    curr = L = temp;
                }

                // Randomly assigned a jump node.
                int jumpNum = (i > 0) ? gen.nextInt(i) : 0;
                PNode<Integer> jump = L;
                while (jumpNum-- != 0) {
                    jump = jump.next;
                }
                temp.jump = jump;
            }

            PNode<Integer> copied = copyPostingsList(L);
            if(!checkPostingsListEqual(L, copied))
                System.out.println("Original and postings are not equal");
        }
    }

    private static <T> boolean checkPostingsListEqual(PNode<T> a, PNode<T> b) {
        while (a != null && b != null) {
            if(!(a.data == b.data && a.jump == null && b.jump == null ||
                    (a.jump != null && b.jump != null && a.jump.data == b.jump.data))) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

}
