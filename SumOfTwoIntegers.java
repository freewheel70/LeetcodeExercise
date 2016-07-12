package leetcode;

/**
 * Created by Administrator on 2016/7/12.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        return (a | b) + (a & b);
    }

    public static void main(String[] args) {
        test(1, 2);
        test(2, 2);
        test(5, 3);
        test(12, 34);
    }

    private static void test(int i, int j) {
        System.out.println(i + " + " + j);
        SumOfTwoIntegers sum = new SumOfTwoIntegers();
        System.out.println(sum.getSum(i, j) + " " + (i & j) + " " + (i | j));
    }
}
