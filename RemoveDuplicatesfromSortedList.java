package leetcode;


public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return head;

        ListNode currentNode = head;
        int currentValue = currentNode.val;

        ListNode nextNode;
        while ((nextNode = currentNode.next) != null) {

            if (nextNode.val == currentValue) {
                currentNode.next = nextNode.next;
            } else {
                currentNode = nextNode;
                currentValue = nextNode.val;
            }
        }
        return head;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
