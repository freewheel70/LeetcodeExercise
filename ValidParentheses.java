package leetcode;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int length = s.length();
        if (length == 0) return true;
        if (length % 2 != 0) return false;

        LinkedList<Character> parentheses = new LinkedList<>();
        parentheses.addFirst(s.charAt(0));
        for (int i = 1; i < length; i++) {
            char next = s.charAt(i);
            if (parentheses.isEmpty()) {
                parentheses.addFirst(next);
                continue;
            }
            char top = parentheses.getFirst();
            switch (top) {
                case '{':
                    if (next == '}') {
                        parentheses.removeFirst();
                    } else if (next == ']' || next == ')') {
                        return false;
                    }else {
                        parentheses.addFirst(next);
                    }
                    break;
                case '[':
                    if (next == ']') {
                        parentheses.removeFirst();
                    } else  if (next == '}' || next == ')') {
                        return false;
                    }else {
                        parentheses.addFirst(next);
                    }
                    break;
                case '(':
                    if (next == ')') {
                        parentheses.removeFirst();
                    } else  if (next == ']' || next == '}') {
                        return false;
                    }else {
                        parentheses.addFirst(next);
                    }
                    break;
                default:
                    return false;
            }
        }
        return parentheses.isEmpty();
    }

    public static void main(String[] args) {
        test("(){}[]");
        test("(}[]");
        test("{()}[]");
        test("[(){}]");
    }

    private static void test(String s) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println("input " + s);
        System.out.println("result " + validParentheses.isValid(s));
        System.out.println("--------------");
    }
}
