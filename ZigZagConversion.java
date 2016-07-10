package leetcode;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ZigZagConversion {
    /**
     * ABCDEFGHIJK
     *
     * A   I
     * B F J
     * C G K
     * D H
     * E
     *
     *  A1      I9
     *  B2  H8  J10  16
     *  C3  G7  K11  15
     *  D4  F6   12  14
     *  E5       13
     *
     *  A1   C3  E5 G7  I9  K11
     *  B2   D4  F6 H8  J10
     *
     *  A1     G7
     *  B2 F6  H8
     *  C3 E5  I9  K11
     *  D4     J10
     */

    public String convert(String s, int numRows) {
        if (numRows==1)
        return "";
    }
}
