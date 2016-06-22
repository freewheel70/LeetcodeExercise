package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/22.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode currentNode = head;
        Set<ListNode> nodes = new HashSet<>();
        nodes.add(currentNode);
        while (currentNode.next != null) {
            if (nodes.contains(currentNode.next)) {
                return true;
            }
            nodes.add(currentNode.next);
            currentNode = currentNode.next;
        }

        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        LinkedListCycle cycle = new LinkedListCycle();
        System.out.println(cycle.hasCycle(node1));

    }
}
