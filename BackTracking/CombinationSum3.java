package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by freewheel on 2017/2/21.
 */
public class CombinationSum3 {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] masks = new int[10];
        Arrays.fill(masks, -1);

        check(0, 0, 0, k, n, masks, new ArrayList<>());

        return results;
    }


    //last 存在的意义是让下一个数大于上一个挑选的数，这样最终答案里才不会出现重复的组合（排列顺序不同）
    private void check(int index, int currentSum, int last, int upper, int target, int[] masks, List<Integer> record) {

        if (index == upper - 1) {
            int lastOne = target - currentSum;
            if (lastOne < 10 && lastOne > last && masks[lastOne] == -1) {
                record.add(lastOne);
                results.add(new ArrayList<>(record));
                record.remove((Integer) lastOne);
            }
            return;
        }

        for (int i = last + 1; i < 10; i++) {
            if (masks[i] == -1) {
                currentSum += i;
                record.add(i);
                masks[i] = 0;

                check(index + 1, currentSum, i, upper, target, masks, record);

                //还原上次的变化
                masks[i] = -1;
                record.remove((Integer) i);
                currentSum -= i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3,7));
    }
}
