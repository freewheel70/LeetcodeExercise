package leetcode.BitManipulation;

import java.util.LinkedList;

/**
 * Created by freewheel on 2017/2/9.
 */
public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
        System.out.println((~5));
    }

    public int findComplement(int num) {
        if (num == 0) return 1;
        LinkedList<Integer> stack = new LinkedList<>();
        while (num != 0) {
            if ((num & 1) == 1) {
                stack.push(0);
            } else {
                stack.push(1);
            }
            num = num >> 1;
        }

        int result = stack.pop();
        while (stack.size() != 0) {
            result = result << 1;
            result += stack.pop();
        }

        return result;
    }
}
