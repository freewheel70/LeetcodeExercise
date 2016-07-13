package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/7/13.
 */
public class MinStack {

    Node top;
    boolean firstPush = true;
    int min, lastMin;

    public MinStack() {

    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.beneath = top;
        top = newNode;
        if (firstPush || x < min) {
            min = x;
            lastMin = min;
            firstPush = false;
        }
    }

    public void pop() {
        int originalTopVal = top.value;
        top = top.beneath;
        if (top == null) {
            firstPush = true;
            min = 0;
        } else if (min == originalTopVal) {
            calculateMin();
        }
    }

    private void calculateMin() {
        if (min == top.value) return;
        min = top.value;
        Node temp = top;
        while (temp.beneath != null) {
            temp = temp.beneath;
            if (temp.value < min) {
                min = temp.value;
                if (min == lastMin)
                    break;
            }
        }
        lastMin = min;
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

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }

}
