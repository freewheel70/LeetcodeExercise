package leetcode;

/**
 * Created by Administrator on 2016/7/7.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head.val == val) {
            head = head.next;
            if (head == null) return null;
        }

        ListNode detector = head, lastValidNode = head;
        while (detector.next != null) {
            detector = detector.next;
            if (detector.val != val) {
                if (lastValidNode.next != detector) {
                    lastValidNode.next = detector;
                }
                lastValidNode = detector;
            }
        }
        if (detector.val == val) {
            lastValidNode.next = null;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        print(node1);

        System.out.println("---");

        RemoveLinkedListElements removes = new RemoveLinkedListElements();
        ListNode node = removes.removeElements(node1, 6);
        print(node);


    }

    private static void print(ListNode node) {
        System.out.println(node.val);
        if (node.next != null) {
            print(node.next);
        }
    }
}
