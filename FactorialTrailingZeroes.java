package leetcode;

/**
 * Created by Administrator on 2016/6/29.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        /**
         * 1 1
         * 2 2
         * 3 6
         * 4 24
         * 5 120
         * 6 720
         * 7
         * 8
         * 9
         * 10 00
         */
        int result = 0;
//        int pow = 1;
        int five = 5;
        while (true) {
//            double five = Math.pow(5, pow);
            int numByFive = (int) (n / five);
            result += numByFive;
            if (numByFive != 0) {
                five *= 5;
            } else {
                return result;
            }
        }

    }


    public static void main(String[] args) {
        factorial(6);
        factorial(9);
        factorial(10);
        factorial(14);
        factorial(15);
        factorial(16);
        factorial(30);
        factorial(2147483647);
    }

    private static void factorial(int i) {
        long result = 1;
//        for (int j = 1; j <= i; j++) {
//            result *= j;
//        }
        System.out.println("input " + i);
        System.out.println(result);
        FactorialTrailingZeroes fZeroes = new FactorialTrailingZeroes();
        System.out.println("fZeroes " + fZeroes.trailingZeroes(i));
        System.out.println("-----");
    }


}
