package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if (numRows <= 0) return list;

        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        list.add(firstLine);

        if (numRows == 1) return list;

        for (int i = 2; i <= numRows; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            List<Integer> lastLine = list.get(list.size() - 1);
            for (int j = 1; j < i - 1; j++) {
                line.add(lastLine.get(j - 1) + lastLine.get(j));
            }
            line.add(1);
            list.add(line);
        }

        return list;
    }

    public static void main(String[] args) {
        test(0);
        test(1);
        test(2);
        test(3);
        test(4);
        test(5);
        test(6);
        test(7);
    }

    private static void test(int num) {
        System.out.println("input:" + num);
        PascalsTriangle triangle = new PascalsTriangle();
        System.out.println(print(triangle.generate(num)));
        System.out.println("----------");
    }

    private static String print(List<List<Integer>> generate) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (int i = 0; i < generate.size(); i++) {
            builder.append(generate.get(i));
            builder.append("\n");
        }
        builder.append("\n}");
        return builder.toString();
    }
}
