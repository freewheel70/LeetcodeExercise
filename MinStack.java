package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/7/13.
 */
public class MinStack {

    Node top;
    boolean firstPush = true;
    int min;

    HashMap<Integer, Integer> numsMap = new HashMap<>();

    public MinStack() {

    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.beneath = top;
        top = newNode;
        if (firstPush || x < min) {
            min = x;
            firstPush = false;
        }
        Integer count = numsMap.get(x);
        numsMap.put(x, (count == null) ? 1 : (count + 1));
    }

    public void pop() {
        Integer count = numsMap.get(top.value);
        if (count == 1) {
            numsMap.remove(top.value);
        } else {
            numsMap.put(top.value, count - 1);
        }
        top = top.beneath;
        if (top == null) {
            firstPush = true;
            min = 0;
        } else {
            calculateMin();
        }
    }

    private void calculateMin() {
        List<Integer> nums = new ArrayList<>(numsMap.keySet());
        Collections.sort(nums);
        min = nums.get(0);
    }

    public int top() {
        return top.value;
    }

    public int getMin() {
        return min;
    }

    static class Node {
        int value;
        Node beneath;

        public Node(int value) {
            this.value = value;
        }
    }
}
