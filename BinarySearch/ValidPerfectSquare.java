package leetcode.BinarySearch;

/**
 * Created by freewheel on 2017/2/14.
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        //perfect: num = same * same
        //     or: same = num / same

        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }

        return x * x == num;
    }
}
