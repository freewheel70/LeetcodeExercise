package leetcode.BinarySearch;

/**
 * Created by freewheel on 2017/2/15.
 */
public class SqrtOfX {
    public int mySqrt(int x) {
        long num = x;
        while (num * num > x) {
            num = (num + x / num) / 2;
        }

        return (int) num;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtOfX().mySqrt(16));
        System.out.println(new SqrtOfX().mySqrt(1));
    }
}
