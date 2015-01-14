package elements.of.programming.interviews;

/**
 * Created by sharath on 1/12/15.
 */
class ListNode<T> {
    T data;
    ListNode next;

    ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public void print() {
        ListNode<T> curr = this;
        while(curr != null) {
            System.out.print("[" + curr.data + "],");
            curr = curr.next;
        }
        System.out.println();
    }
}