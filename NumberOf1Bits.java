package leetcode;

import StringTest.Format;

import java.util.Formatter;

/**
 * Created by Administrator on 2016/6/23.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        /**
         *  1       1
         *  2       10
         *  3       11
         *  4       100
         *  5       101
         *  6       110
         *  7       111
         *  8       1000
         *  9       1001
         *  10      1010
         */

        if (n == 0 || n == 1) return n;

        int num = n;
        int maxN = 1;
        while ((n = n / 2) != 1) {
            maxN++;
        }

        int count = 0;
        for (int i = maxN; i >= 0; i--) {
            double temp = Math.pow(2, i);
//            System.out.println("temp " + temp);
            if (num > temp) {
                num -= temp;
                count++;
            } else if (num == temp) {
                count++;
                break;
            }
        }
        return count;
    }

    public int hammingWeight2(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public int hammingWeight4(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


    public static void main(String[] args) {
        testNum(0);
        testNum(1);
        testNum(2);
        testNum(3);
        testNum(4);
        testNum(5);
        testNum(6);
        testNum(7);
        testNum(8);
        testNum(9);
        testNum(10);
    }

    private static void testNum(int i) {
        NumberOf1Bits numOfOne = new NumberOf1Bits();
        System.out.println("number " + i + " ;result1= " + numOfOne.hammingWeight(i) + " ;result2= " + numOfOne.hammingWeight2(i) + " ;result3= " + numOfOne.hammingWeight3(i) + " ;result4= " + numOfOne.hammingWeight4(i));
        System.out.println("");
    }
}
