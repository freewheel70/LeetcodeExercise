package leetcode;

/**
 * Created by Administrator on 2016/7/16.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        boolean isPositive = true;
        str = str.trim();
        int length = str.length();
        if (length == 0) return 0;
        int result = 0;
        char firstChar = str.charAt(0);
        if (firstChar == '+')
            isPositive = true;
        else if (firstChar == '-')
            isPositive = false;
        else {
            result = charToInt(firstChar);
            if (result == -1) {
                return 0;
            }
        }
        int maxPreBound = Integer.MAX_VALUE / 10;

        for (int i = 1; i < length; i++) {
            int temp = charToInt(str.charAt(i));
            if (temp == -1)
                break;
            else {
                if (result > maxPreBound)
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = result * 10 + temp;
            }
        }

        if (isPositive) {
            if (result < 0)
                return Integer.MAX_VALUE;
            else
                return result;
        } else {
            if (result < 0)
                return Integer.MIN_VALUE;
            else
                return -result;
        }
    }

    private int charToInt(char aChar) {
        int num = aChar - '0';
        if (num > 9 || num < 0) return -1;
        return num;
    }

    public static void main(String[] args) {

        test("123");
        test("-123");
        test("+123");
        test("x123");
        test("1x23");
        test("    123");
        test("" + (Integer.MAX_VALUE));
        test("2147483649");
        test("6147483647");
        test("" + (Integer.MIN_VALUE));
        test("-2147483649");
        test("-6147483648");
    }

    private static void test(String s) {
        System.out.println("string " + s);
        System.out.println("number " + new StringToInteger().myAtoi(s));
        System.out.println("--------");
    }

}
