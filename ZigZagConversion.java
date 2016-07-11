package leetcode;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ZigZagConversion {
    /**
     * ABCDEFGHIJK
     * <p>
     * A   I
     * B F J
     * C G K
     * D H
     * E
     * <p>
     * A1   C3  E5 G7  I9  K11
     * B2   D4  F6 H8  J10
     * <p>
     * A1     E5     I9             4
     * B2  D4 F6  H8 J10            2  4
     * C3     G7     K11               4
     * <p>
     * A1     G7                    6
     * B2 F6  H8                    4  6
     * C3 E5  I9  K11               2  6
     * D4     J10                      6
     * <p>
     * A1      I9                   8
     * B2  H8  J10  16              6  8
     * C3  G7  K11  15              4  8
     * D4  F6   12  14              2  8
     * E5       13                     8
     */

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int length = s.length();
        if (numRows == 2) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                for (int i = j; i < length; i += 2) {
                    builder.append(s.charAt(i));
                }
            }
            return builder.toString();
        }
        int diffBig = (numRows - 1) * 2;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i += diffBig) {
            builder.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            int diffSmall1 = diffBig - (i * 2);
            int diffSmall2 = (i * 2);
            boolean toggle = false;
            for (int j = i; j < length; ) {
                builder.append(s.charAt(j));
                j += (toggle ? diffSmall2 : diffSmall1);
                toggle = (!toggle);
            }
        }
        for (int i = numRows - 1; i < length; i += diffBig) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String input = "ABCDEFGHIJK";
        test(input, 2);
        test(input, 3);
        test(input, 4);
        test(input, 5);
    }

    private static void test(String input, int nums) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println("input " + input);
        System.out.println("nums " + nums);
        System.out.println(zigZagConversion.convert(input, nums));
        System.out.println("---------------------------------------");

    }
}
