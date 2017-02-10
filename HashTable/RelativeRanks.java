package leetcode.HashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by freewheel on 2017/2/10.
 */
public class RelativeRanks {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(nums)));
    }

    //用hashmap，记录分数和位置的对应信息
    //将分数排序
    //从高到低进行“颁奖”
    //根据分数在map中找到对应的位置
    //给对应的位置颁奖
    public String[] findRelativeRanks(int[] nums) {
        if (nums.length == 0) return new String[0];

        String[] ret = new String[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);


        for (int i = nums.length - 1; i >= 0; i--) {

            int score = nums[i];
            int pos = map.get(score);

            int index = nums.length - 1 - i;
            if (index < 3) {
                if (index == 0) {
                    ret[pos] = "Gold Medal";
                } else if (index == 1) {
                    ret[pos] = "Silver Medal";
                } else {
                    ret[pos] = "Bronze Medal";
                }
            } else {
                ret[pos] = String.valueOf(index + 1);
            }
        }

        return ret;
    }
}
