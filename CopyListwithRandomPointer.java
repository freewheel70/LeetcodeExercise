package leetcode;


import java.util.HashMap;

/**
 * Created by freewheel on 2017/2/8.
 */
public class CopyListwithRandomPointer {

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public static void main(String[] args) {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        one.next = two;
        one.random = two;
        two.random = one;

        print(one);

        RandomListNode copy = copyRandomList(one);
        print(copy);
    }

    private static void print(RandomListNode node) {
        if (node == null) return;
        StringBuilder builder = new StringBuilder();

        builder.append("label: ");
        builder.append(node.label);
        builder.append("; next: ");
        if (node.next == null) {
            builder.append("null");
        } else {
            builder.append(node.next.label);
        }
        builder.append("; random: ");
        if (node.random == null) {
            builder.append("null");
        } else {
            builder.append(node.random.label);
        }

        System.out.println(builder.toString());

        print(node.next);
    }

    //copy a node = copy label + node pointers (next,random)
    //iterate next -> copy all without random
    // use hashmap to bind new and old
    //iterate again -> copy random

    public static RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode runningNode = head;

        RandomListNode headCopy = new RandomListNode(head.label);
        map.put(head, headCopy);

        RandomListNode runningNodeCopy = headCopy;

        while (runningNode.next != null) {
            RandomListNode nextNode = runningNode.next;
            RandomListNode nextNodeCopy = new RandomListNode(nextNode.label);
            map.put(nextNode, nextNodeCopy);
            runningNodeCopy.next = nextNodeCopy;

            runningNode = nextNode;
            runningNodeCopy = nextNodeCopy;
        }

        runningNode = head;
        runningNodeCopy = headCopy;
        while (runningNode != null) {
            RandomListNode randomNode = runningNode.random;
            if (randomNode == null) {
                runningNodeCopy.random = null;
            } else {
                runningNodeCopy.random = map.get(randomNode);
            }
            runningNode = runningNode.next;
            runningNodeCopy = runningNodeCopy.next;
        }

        return headCopy;
    }


}
