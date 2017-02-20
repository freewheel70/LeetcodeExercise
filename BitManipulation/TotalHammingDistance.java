package leetcode.BitManipulation;

import java.util.*;

/**
 * Created by freewheel on 2017/2/17.
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int dist = 0;

        //record the different values and their amount
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> keys = map.keySet();
        if (keys.size() == 1) return 0;
//        keys.toArray();
        List<Integer> keysList = new ArrayList<>(keys);

        //only compare the different values, and calc the HammingDistance
        //by multiply their amount
        int size = keysList.size();
        for (int i = 0; i < size; i++) {
            int currentNum = keysList.get(i);
            for (int j = i + 1; j < size; j++) {
                int anotherNum = keysList.get(j);
                int temp = currentNum ^ anotherNum;
                int hDist = Integer.bitCount(temp);
                dist += (hDist * map.get(currentNum) * map.get(anotherNum));
            }
        }

        return dist;
    }


    public int totalHammingDistance2(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }

}
