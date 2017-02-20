package leetcode.LinkedList;

import java.util.LinkedList;

/**
 * Created by freewheel on 2017/2/17.
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<Integer> stack3 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            stack3.push(sum);
        }

        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            stack3.push(sum);
        }

        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            stack3.push(sum);
        }

        if (carry != 0) {
            stack3.push(carry);
        }

        ListNode head = new ListNode(stack3.pop());
        ListNode tempNode = head;
        while (!stack3.isEmpty()) {
            ListNode node = new ListNode(stack3.pop());
            tempNode.next = node;
            tempNode = node;
        }

        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode lastNode = null;
        ListNode headNode = null;

        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            headNode = new ListNode(sum);
            headNode.next = lastNode;
            lastNode = headNode;
        }

        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            headNode = new ListNode(sum);
            headNode.next = lastNode;
            lastNode = headNode;
        }

        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            headNode = new ListNode(sum);
            headNode.next = lastNode;
            lastNode = headNode;
        }

        if (carry != 0) {
            headNode = new ListNode(carry);
            headNode.next = lastNode;
        }

        return headNode;
    }
}
