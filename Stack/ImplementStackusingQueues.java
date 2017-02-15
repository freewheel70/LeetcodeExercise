package leetcode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by freewheel on 2017/2/15.
 */
public class ImplementStackusingQueues {

    static class MyStack {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (q1.isEmpty()) {
                q2.offer(x);
            } else {
                q1.offer(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (q1.isEmpty()) {
                while (q2.size() != 1) {
                    q1.offer(q2.poll());
                }
                return q2.poll();
            } else {
                while (q1.size() != 1) {
                    q2.offer(q1.poll());
                }
                return q1.poll();
            }
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (q1.isEmpty()) {
                while (q2.size() != 1) {
                    q1.offer(q2.poll());
                }
                Integer n = q2.poll();
                q1.offer(n);
                return n;
            } else {
                while (q1.size() != 1) {
                    q2.offer(q1.poll());
                }
                Integer n = q1.poll();
                q2.offer(n);
                return n;
            }
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.push(0);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
