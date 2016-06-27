package leetcode;

/**
 * Created by Administrator on 2016/6/27.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (true) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return (n == 1);
            }
        }
    }

    public static void main(String[] args) {
        test(0);
        test(1);
        test(3);
        test(9);
        test(21);
        test(27);
    }

    private static void test(int i) {
        System.out.println("input: " + i);
        PowerofThree powerofThree = new PowerofThree();
        System.out.println("result: " + powerofThree.isPowerOfThree(i));
        System.out.println("------");
    }
}
