package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/7/22.
 */
public class TopKFrequentElements {

    HashMap<Integer, Integer> map = new HashMap<>();

    //not that good answer
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            saveToMap(nums[i]);
        }

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        values = values.subList(0, k);

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (values.contains(entry.getValue())) {
                if (!result.contains(entry.getKey())) {
                    result.add(entry.getKey());
                }
            }
        }

        return result;
    }

    private void saveToMap(int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    //better answer
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            saveToMap(nums[i]);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            queue.add(entry);
        }

        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = new TopKFrequentElements().topKFrequent(new int[]{1,1,2,2, 3}, 2);
        System.out.println(integers);
    }
}
