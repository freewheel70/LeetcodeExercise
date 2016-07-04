package leetcode;

/**
 * Created by Administrator on 2016/7/4.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode front = head, tail = head;
        for (int i = 0; i < n - 1; i++) {
            if (front.next != null) {
                front = front.next;
            } else {
                //n is greater than list's length
                return head;
            }
        }

        if (front.next == null) {
            //remove head
            return head.next;
        }

        front = front.next;

        while (front.next != null) {
            front = front.next;
            tail = tail.next;
        }

        tail.next = tail.next.next;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
