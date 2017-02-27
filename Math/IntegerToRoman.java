package leetcode.Math;

/**
 * Created by freewheel on 2017/2/21.
 * <p>
 * 罗马数字共有7个，即Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和Ⅿ（1000）。
 * <p>
 * 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
 * <p>
 * 右加左减：
 * 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
 * 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
 * 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 * 但是，左减时不可跨越一个位值。比如，99不可以用IC（ 100-1）表示，而是用XCIX（ [100-10]+[10-1]）表示。（等同于阿拉伯数字每位数字分别表示。）
 * 左减数字必须为一位，比如8写成VIII，而非IIX。
 * 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）
 * <p>
 * 数码限制：
 * 同一数码最多只能连续出现三次，如40不可表示为XXXX，而要表示为XL。
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        if (num >= 1000) {
            int numsOfThousands = num / 1000;
            for (int i = 0; i < numsOfThousands; i++) {
                builder.append('M');
            }
            num = num % 1000;
        }
        if (num >= 900) {
            builder.append("CM");
            num -= 900;//剩十位个位
        } else if (num >= 500) {
            builder.append('D');
            num -= 500;
            int numsOfHundreds = num / 100;
            for (int i = 0; i < numsOfHundreds; i++) {
                builder.append('C');
            }
            num = num % 100;//剩十位个位
        } else if (num >= 400) {
            builder.append("CD");
            num -= 400;//剩十位个位
        } else {
            int numsOfHundreds = num / 100;
            for (int i = 0; i < numsOfHundreds; i++) {
                builder.append('C');
            }
            num = num % 100;//剩十位个位
        }

        if (num >= 90) {
            builder.append("XC");
            num -= 90;//剩个位
        } else if (num >= 50) {
            builder.append('L');
            num -= 50;
            int numsOfTens = num / 10;
            for (int i = 0; i < numsOfTens; i++) {
                builder.append('X');
            }
            num = num % 10;//剩个位
        } else if (num >= 40) {
            builder.append("XL");
            num -= 40;//剩个位
        } else {
            int numsOfTens = num / 10;
            for (int i = 0; i < numsOfTens; i++) {
                builder.append('X');
            }
            num = num % 10;//剩个位
        }

        if (num == 9) {
            builder.append("IX");
        } else if (num >= 5) {
            builder.append('V');
            num -= 5;
            int numsOfOnes = num;
            for (int i = 0; i < numsOfOnes; i++) {
                builder.append('I');
            }
        } else if (num == 4) {
            builder.append("IV");
        } else {
            int numsOfOnes = num;
            for (int i = 0; i < numsOfOnes; i++) {
                builder.append('I');
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1000));
    }
}
