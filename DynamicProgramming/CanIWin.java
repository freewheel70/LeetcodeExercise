package leetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by freewheel on 2017/2/21.
 */
public class CanIWin {

    public static void main(String[] args) {
        System.out.println(new CanIWin().canIWin(10, 27));
    }

    Map<Integer, Boolean> map = new HashMap<>();
    boolean[] used;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        used = new boolean[maxChoosableInteger + 1];

        boolean result = helper(desiredTotal);
        return result;
    }

    public boolean helper(int desiredTotal) {
        if (desiredTotal <= 0) return false;

        int key = format(used);

        if (!map.containsKey(key)) {
            // try every unchosen number as next step
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;

                    // check whether this lead to a win (i.e. the other player lose)
                    if (!helper(desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        System.out.println("desiredTotal win  " + desiredTotal);
                        return true;
                    }

                    //recover
                    used[i] = false;
                }
            }

            map.put(key, false);
            System.out.println("desiredTotal lose  " + desiredTotal);
        }


        return map.get(key);
    }

    // transfer boolean[] to an Integer
    public int format(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) num |= 1;
        }
        return num;
    }
}
