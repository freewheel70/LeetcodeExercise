package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/7/1.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
            return list;
        } else if (rowIndex == 1) {
            list.add(1);
            list.add(1);
            return list;
        }

        List<Integer> lastLine = new ArrayList<>();
        lastLine.add(1);
        lastLine.add(1);

        for (int i = 1; i < rowIndex; i++) {
            // list.clear();
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j <= i; j++) {
                list.add(lastLine.get(j - 1) + lastLine.get(j));
            }
            list.add(1);
            //  System.out.println(list);

            if (i == rowIndex - 1)  return list;
            lastLine = new ArrayList<>(list);
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
    }

    private static void test(int num) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        System.out.println("input " + num);
        System.out.println("result " + pascalsTriangleII.getRow(num));
        System.out.println("-------");
    }
}
