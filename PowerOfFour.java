package leetcode;

/**
 * Created by Administrator on 2016/6/27.
 */
public class PowerOfFour {
    public boolean isPowerOfFour1(int num) {
        //4   100
        //16  10000
        if (num <= 0) return false;
        if (num == 1) return true;
        String binaryString = Integer.toBinaryString(num);
        if ((binaryString.length() - 1) % 2 != 0) {
            return false;
        }

        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1')
                return false;
        }

        return true;
    }

    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
//        if (num == 1) return true;

        while (true) {
            if ((num & 3) == 0) {
                num >>= 2;
            } else {
                return num == 1;
            }
        }
    }

    public static void main(String[] args) {
        test(0);
        test(1);
        test(4);
        test(5);
        test(17);
        test(16);
    }

    private static void test(int i) {
        PowerOfFour powerOfFour = new PowerOfFour();
        System.out.println("input " + i);
        System.out.println("result " + powerOfFour.isPowerOfFour(i));
        System.out.println("---");
    }
}
