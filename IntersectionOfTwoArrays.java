package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/6/21.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        if (nums1.length > nums2.length) {
            for (int i = 0; i < nums2.length; i++) {
                set.add(nums2[i]);
            }

            for (int i = 0; i < nums1.length; i++) {
                int temp = nums1[i];
                if (set.contains(temp)) {
                    resultSet.add(temp);
                }
            }
        } else {
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }

            for (int i = 0; i < nums2.length; i++) {
                int temp = nums2[i];
                if (set.contains(temp)) {
                    resultSet.add(temp);
                }
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer integer : resultSet) {
            result[i++] = integer;
        }

        return result;

    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Map<Integer, Integer> num1Map = new HashMap<>();
        Map<Integer, Integer> num2Map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            Integer value = num1Map.get(key);
            if (value == null) {
                num1Map.put(key, 1);
            } else {
                num1Map.put(key, value + 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            Integer value = num2Map.get(key);
            if (value == null) {
                num2Map.put(key, 1);
            } else {
                num2Map.put(key, value + 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int key : num1Map.keySet()) {
            if (num2Map.containsKey(key)) {
                Integer num1Val = num1Map.get(key);
                Integer num2Val = num2Map.get(key);
                int min = num1Val < num2Val ? num1Val : num2Val;

                for (int i = 0; i < min; i++) {
                    resultList.add(key);
                }

            }
        }

        int[] result = new int[resultList.size()];
        int i = 0;
        for (Integer integer : resultList) {
            result[i++] = integer;
        }

        return result;

    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        int num1[] = {1, 2, 2, 1};
        int num2[] = {2, 1, 2};
        System.out.println(Arrays.toString(intersection.intersection2(num1, num2)));
    }
}
