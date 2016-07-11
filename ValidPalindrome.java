package leetcode;

/**
 * Created by Administrator on 2016/7/11.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        if (length <= 1) return true;
        int head = 0, tail = length - 1;
        char[] charArray = s.toCharArray();
        while (head < tail) {
            char headChar = charArray[head];
            if (!Character.isAlphabetic(headChar) && !Character.isDigit(headChar)) {
                head++;
                continue;
            }
            char tailChar = charArray[tail];
            if (!Character.isAlphabetic(tailChar)&& !Character.isDigit(tailChar)) {
                tail--;
                continue;
            }
            if (headChar == tailChar || Character.toLowerCase(headChar) == Character.toLowerCase(tailChar)) {
                head++;
                tail--;
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        test("0Pe");//"0P"
    }

    private static void test(String s) {
        System.out.println("input " + s);
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println("result " + validPalindrome.isPalindrome(s));
    }
}
