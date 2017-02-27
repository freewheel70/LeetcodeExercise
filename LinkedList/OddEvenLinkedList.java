package leetcode.LinkedList;

/**
 * Created by freewheel on 2017/2/23.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next == null) return head;


        //using temp variables to record intermediate node to avoid getting lost
        ListNode odd = head;
        ListNode oddTail;
        ListNode nextOdd;

        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode evenTail;
        ListNode nextEven;

        // 1 2 3

        while (true) {
            nextOdd = even.next;//nullable
            if (nextOdd != null) {

                nextEven = nextOdd.next;

                odd.next = nextOdd;
                odd = nextOdd;

                if (nextEven != null) {
                    even.next = nextEven;
                    even = nextEven;
                } else {
                    break;
                }

            } else {
                break;
            }
        }
        oddTail = odd;
        evenTail = even;

        oddTail.next = evenHead;
        evenTail.next = null;

        return head;
    }
}
