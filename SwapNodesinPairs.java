package leetcode;

/**
 * Created by Administrator on 2016/6/22.
 */
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode secondNode = head.next;
        ListNode newHead = head.next;

        swapNodes(head);

        newHead.next = head;
        return newHead;
        /**
         *  1 2 3 4 -> 2 1 4 3
         *  1 2 3 4 5 6 -> 2 1 4 3 6 5
         *  1 2 3 4 5 -> 2 1 4 3 5
         */
    }

    public void swapNodes(ListNode node) {
//        System.out.println("swapNodes " + node.val);
        ListNode tempNode = node.next.next;
        if (tempNode == null) {
            node.next = null;
            return;
        }
        if (tempNode.next == null) {
            node.next = tempNode;
        } else {
            node.next = tempNode.next;
            if (node.next.next == null) {
                node.next.next = tempNode;
                tempNode.next = null;
            } else {
                swapNodes(tempNode);
                node.next.next = tempNode;
            }
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }

    private static void printNode(ListNode node) {

        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
        System.out.println("---");

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = null;
//        node3.beneath = node4;
//        node4.beneath = node5;
//        node5.beneath = null;
//        node6.beneath = null;

        printNode(node1);

        SwapNodesinPairs swaq = new SwapNodesinPairs();
        ListNode newNode = swaq.swapPairs(node1);

        printNode(newNode);
    }
}
