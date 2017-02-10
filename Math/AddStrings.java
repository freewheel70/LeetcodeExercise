package leetcode.Math;

/**
 * Created by freewheel on 2017/2/9.
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("1", "9"));
        //6913259244
        //  71103343
    }

    //TODO Not yet complete
    //Value overflow problem
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int commonLen = Math.min(num1.length(), num2.length());

        int more = 0;
        int tempSum = 0;
        for (int i = 0; i < commonLen; i++) {
            int digit1 = num1.charAt(num1.length() - 1 - i) - '0';
            int digit2 = num2.charAt(num2.length() - 1 - i) - '0';
            tempSum = digit1 + digit2 + more;
            more = tempSum / 10;
            tempSum = tempSum % 10;
            builder.insert(0, tempSum);
        }

        if (num1.length() > commonLen) {
            for (int i = commonLen; i < num1.length(); i++) {
                int digit1 = num1.charAt(num1.length() - 1 - i) - '0';
                tempSum = digit1  + more;
                more = tempSum / 10;
                tempSum = tempSum % 10;
                builder.insert(0, tempSum);
            }
        }

        if (num2.length() > commonLen) {
            for (int i = commonLen; i < num2.length(); i++) {
                int digit2 = num2.charAt(num2.length() - 1 - i) - '0';
                tempSum = digit2  + more;
                more = tempSum / 10;
                tempSum = tempSum % 10;
                builder.insert(0, tempSum);
            }
        }

        if (more!=0){
            builder.insert(0,more);
        }

        return builder.toString();
    }
}
