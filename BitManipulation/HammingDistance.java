package leetcode.BitManipulation;

/**
 * Created by freewheel on 2017/2/9.
 */
public class HammingDistance {
    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(new HammingDistance().hammingDistance(x, y));
    }

    public int hammingDistance(int x, int y) {
        int tempResult = x ^ y;
        int counter = 0;
        while (tempResult != 0) {
            if ((tempResult & 1) == 1) {
                counter++;
            }

            tempResult = (tempResult >> 1);
        }

        return counter;
    }
}
