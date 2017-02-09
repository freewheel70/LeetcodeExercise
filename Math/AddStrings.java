package leetcode.Math;

/**
 * Created by freewheel on 2017/2/9.
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("6913259244", "71103343"));
        //6913259244
        //  71103343
    }

    //TODO Not yet complete
    //Value overflow problem
    public String addStrings(String num1, String num2) {
        int commonLen = Math.min(num1.length(), num2.length());
        long result = 0;
        for (int i = 0; i < commonLen; i++) {
            int digit1 = num1.charAt(num1.length() - 1 - i) - '0';
            int digit2 = num2.charAt(num2.length() - 1 - i) - '0';
            result += ((digit1 + digit2) * Math.pow(10, i));
        }

        if (num1.length() > commonLen) {
            for (int i = commonLen; i < num1.length(); i++) {
                int digit1 = num1.charAt(num1.length() - 1 - i) - '0';
                result += (digit1 * Math.pow(10, i));
            }
        }

        if (num2.length() > commonLen) {
            for (int i = commonLen; i < num2.length(); i++) {
                int digit2 = num2.charAt(num2.length() - 1 - i) - '0';
                result += (digit2 * Math.pow(10, i));
            }
        }

        return String.valueOf(result);
    }
}
