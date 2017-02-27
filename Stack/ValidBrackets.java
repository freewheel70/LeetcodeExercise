package leetcode.Stack;

import java.util.LinkedList;

/**
 * Created by freewheel on 2017/2/27.
 */
public class ValidBrackets {

    public static void main(String[] args) {
        ValidBrackets vb = new ValidBrackets();
        System.out.println(vb.validBrackets("()(())"));
        System.out.println(vb.validBrackets("(()(())"));
        System.out.println(vb.validBrackets("()(()))"));
        System.out.println(vb.validBrackets("()(())("));
        System.out.println(vb.validBrackets("((()))"));
    }

    public boolean validBrackets(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        int index = 0;
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            index++;
        }

        return stack.isEmpty();

    }
}
