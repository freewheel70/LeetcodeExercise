package leetcode;

/**
 * Created by Administrator on 2016/6/22.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeNode;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            mergeNode = l1;
            mergeNodes(mergeNode, l1.next, l2);
        } else {
            mergeNode = l2;
            mergeNodes(mergeNode, l1, l2.next);
        }

        return mergeNode;
    }

    public void mergeNodes(ListNode targetNode, ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) {
//            targetNode.next = null;
//            return;
//        } else if (l1 == null && l2 != null) {
//            targetNode.next = l2;
//            mergeNodes(targetNode.next, l1, l2.next);
//        } else if (l1 != null && l2 == null) {
//            targetNode.next = l1;
//            mergeNodes(targetNode.next, l1.next, l2);
//        } else {
//            if (l1.val < l2.val) {
//                targetNode.next = l1;
//                mergeNodes(targetNode.next, l1.next, l2);
//            } else {
//                targetNode.next = l2;
//                mergeNodes(targetNode.next, l1, l2.next);
//            }
//        }

        if (l1==null){
            if (l2==null){
                targetNode.next = null;
            }else {
                targetNode.next = l2;
                mergeNodes(targetNode.next, l1, l2.next);
            }
        }else {
            if (l2==null){
                targetNode.next = l1;
                mergeNodes(targetNode.next, l1.next, l2);
            }else {
                if (l1.val < l2.val) {
                    targetNode.next = l1;
                    mergeNodes(targetNode.next, l1.next, l2);
                } else {
                    targetNode.next = l2;
                    mergeNodes(targetNode.next, l1, l2.next);
                }
            }
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode node1_ = new ListNode(2);
        ListNode node2_ = new ListNode(6);
        ListNode node3_ = new ListNode(8);
        ListNode node4_ = new ListNode(10);
        ListNode node5_ = new ListNode(12);

        node1_.next = node2_;
        node2_.next = node3_;
        node3_.next = node4_;
        node4_.next = node5_;
        node5_.next = null;

        printNodes(node1);
        printNodes(node1_);

        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        ListNode result = merge.mergeTwoLists(node1, node1_);

        System.out.println("---");
        printNodes(result);
    }

    private static void printNodes(ListNode node) {
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
