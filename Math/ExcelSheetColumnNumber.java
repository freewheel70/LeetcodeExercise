package leetcode.Math;

/**
 * Created by freewheel on 2017/2/11.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("C"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("BA"));
    }

    /**
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * BA -> 53
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int length = s.length();
        int num = 0;
        for (int i = 0; i < length; i++) {
            int raw = s.charAt(i) - 'A' + 1;
            int exponent = length - 1 - i;
            num += (Math.pow(26, exponent) * raw);
        }
        return num;
    }
}
