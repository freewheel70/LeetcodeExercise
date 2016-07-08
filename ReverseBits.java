package leetcode;

import java.util.BitSet;

/**
 * Created by Administrator on 2016/7/8.
 */
public class ReverseBits {
    public int reverseBits1(int n) {
        BitSet bitSet = new BitSet();
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & n) != 0) {
                bitSet.set(i);
            } else {
                bitSet.clear(i);
            }
        }

//        System.out.println(Integer.toBinaryString(n));

        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitSet.get(i)) {
                result |= (1 << (31 - i));
            }
        }
//        System.out.println(Integer.toBinaryString(result));

        return result;
    }

    public int reverseBits(int n) {
        boolean[] bitSet = new boolean[32];
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & n) != 0) {
                bitSet[i] = true;
            }
        }

//        System.out.println(Integer.toBinaryString(n));

        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitSet[i]) {
                result |= (1 << (31 - i));
            }
        }
//        System.out.println(Integer.toBinaryString(result));

        return result;
    }


    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }

}
