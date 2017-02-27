package leetcode;

/**
 * Created by freewheel on 2017/2/26.
 */
public class ExistDuplicatesInArray {
    public boolean checkDuplicates(int[] target) {
        //if no more additional conditions, the raw method
        //O(n^2)

        if (target == null || target.length == 0 || target.length == 1) {
            return false;
        }


        for (int i = 1; i < target.length; i++) {
            int current = target[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current == target[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    //Check if there exist two indexes i and j such that a[i]=a[j] && j-i>=k (k is given in input).
    public boolean checkDuplicates(int[] target, int k) {
        if (target == null || target.length == 0 || target.length == 1) {
            return false;
        }
        if (k <= 0) {
            return true;
        }

        for (int i = 0; i < target.length - k; i++) {
            int current = target[i];
            int adder = k;
            while (i + k < target.length) {
                if (current == target[i + k]) {
                    return true;
                }
            }
        }

        return false;
    }

}
