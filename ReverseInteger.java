package leetcode;

/**
 * Created by Administrator on 2016/7/12.
 */
public class ReverseInteger {
    private static char[] MAX_NUM = "2147483647".toCharArray();

    public int reverse1(int x) {
        if (x == 0) return 0;
        if (x > 0) {
            if (x < 10) {
                return x;
            }
            return Integer.valueOf(reversePositive(x));
        } else {
            if (x > -10) {
                return x;
            }
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            return -Integer.valueOf(reversePositive(-x));
        }
    }

    private String reversePositive(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int length = chars.length;
        if (length < 10) {
            for (int i = 0; i < length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[length - 1 - i];
                chars[length - 1 - i] = temp;
            }
        } else {
            boolean shouldValid = false;
            for (int i = 0; i < length / 2; i++) {
                char temp = chars[length - 1 - i];
                chars[length - 1 - i] = chars[i];
                chars[i] = temp;
                if (!shouldValid) {
                    if (temp > MAX_NUM[i]) {
                        return "0";
                    } else if (temp < MAX_NUM[i]) {
                        shouldValid = true;
                    }
                }
            }

            for (int i = length / 2; i < 10; i++) {
                if (chars[i] > MAX_NUM[i]) {
                    return "0";
                } else if (chars[i] < MAX_NUM[i]) {
                    break;
                }
            }

        }

        return new String(chars);
    }

    public int reverse(int x) {
        if (x < 10 && x > -10) return x;
        if (x > 0) {
            int remainder = (x % 10);
            x /= 10;
            int result = remainder;
            while (x >= 10) {
                remainder = (x % 10);
                x /= 10;
                result = (result * 10) + remainder;
            }
            if (result > (Integer.MAX_VALUE / 10)) {
                return 0;
            }
            result = (result * 10) + x;
            return result < 0 ? 0 : result;
        } else {
            int remainder = (x % 10);
            x /= 10;
            int result = remainder;
            while (x <= -10) {
                remainder = (x % 10);
                x /= 10;
                result = (result * 10) + remainder;
            }
            if (result < (Integer.MIN_VALUE / 10)) {
                return 0;
            }
            result = (result * 10) + x;
            return result > 0 ? 0 : result;
        }
    }

    public static void main(String[] args) {
//        test(Integer.MAX_VALUE);
        test(Integer.MIN_VALUE + 1);
        test(Integer.MIN_VALUE);
//        test(-8989);
        test(1534236469);
        test(-100);
        test(2147483647);
//        test(2111111111);
    }

    private static void test(int i) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println("input " + i);
        System.out.println("result " + reverseInteger.reverse(i));
        System.out.println("--------------------");
    }
}
