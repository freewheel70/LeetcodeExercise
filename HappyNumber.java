package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/21.
 */

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(29));
    }


    public boolean isHappy(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        Set<Integer> set = new HashSet<>();

        int result = n;
        while (true) {
            result = happyResult(result);
            if (result == 1) {
                return true;
            }
            if (set.contains(result)) {
                return false;
            } else {
                set.add(result);
            }
        }
    }

    private int happyResult(int n) {
        String numStr = String.valueOf(n);
        int result = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int temp = numStr.charAt(i) - '0';
            result += (temp * temp);
        }

        System.out.println("n = " + n + "; result = " + result);
        return result;
    }
}
