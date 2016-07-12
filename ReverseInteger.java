package leetcode;

/**
 * Created by Administrator on 2016/7/12.
 */
public class ReverseInteger {
    private static char[] MAX_NUM = "2147483647".toCharArray();

    public int reverse(int x) {
        if (x == 0) return 0;
        if (x > 0) {
            return Integer.valueOf(reversePositive(String.valueOf(x), true));
        } else {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            String negativeNum = "-" + reversePositive(String.valueOf(x), false);
            return Integer.valueOf(negativeNum);
        }
    }

    private String reversePositive(String str, boolean isPositive) {
        if (!isPositive) {
            str = str.substring(1);
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }

        String result = String.valueOf(chars);
        if (result.length() == 10) {
            if (isPositive) {
                for (int i = 0; i < 10; i++) {
                    if (result.charAt(i) > MAX_NUM[i]) {
                        return "0";
                    } else if (result.charAt(i) < MAX_NUM[i]) {
                        break;
                    }
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    if (result.charAt(i) < MAX_NUM[i]) {
                        return "0";
                    } else if (result.charAt(i) > MAX_NUM[i]) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        test(Integer.MAX_VALUE);
        test(Integer.MIN_VALUE+1);
//        test(Integer.MIN_VALUE + 1);
//        test(-8989);
//        test(2000);
//        test(2147483647);
//        test(2111111111);
//        test(-2147483648);
//        test(-2147483648);
    }

    private static void test(int i) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println("input " + i);
        System.out.println("result " + reverseInteger.reverse(i));
        System.out.println("--------------------");
    }
}
