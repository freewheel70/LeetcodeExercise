package leetcode.BackTracking;

import java.util.*;

/**
 * Created by freewheel on 2017/2/23.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> strings = new GenerateParentheses().generateParenthesis(7);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return Collections.emptyList();


        List<String> results = new ArrayList<>( );

//        Set<String> container = new HashSet<>();
        StringBuilder currentStr = new StringBuilder();
        currentStr.append('(');
        generate(currentStr, 1, 0, n, results);



        return results;
    }

    private void generate(StringBuilder currentStr, int numOfLeft, int numOfRight, int total, List<String> container) {
        if (numOfLeft == total && numOfRight == total) {
            container.add(currentStr.toString());
            return;
        }


        if (total - numOfLeft > 0) {
            currentStr.append('(');
            generate(currentStr, numOfLeft + 1, numOfRight, total, container);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }


        if (numOfLeft - numOfRight > 0) {
            currentStr.append(')');
            generate(currentStr, numOfLeft, numOfRight + 1, total, container);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }


    }
}
