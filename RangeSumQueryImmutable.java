package leetcode;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/9.
 */
public class RangeSumQueryImmutable {

    static class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    static class NumArray2 {

        HashMap<Marks, Integer> cache = new HashMap<>();

        int[] nums = null;

        public NumArray2(int[] nums) {
            this.nums = nums;
            if (nums.length > 0) {
                cache.put(new Marks(0, 0), nums[0]);

                for (int i = 1; i < nums.length; i++) {
                    int result = nums[i] + cache.get(new Marks(0, i - 1));
                    cache.put(new Marks(0, i), result);
                }
            }
        }

        public int sumRange(int i, int j) {

            if (i == 0) {
                if (j == 0) {
                    return nums[0];
                }
                return cache.get(new Marks(i, j));
            } else {
                Marks mark = new Marks(i, j);
                Integer value = cache.get(mark);
                if (value == null) {
                    value = cache.get(new Marks(0, j)) - cache.get(new Marks(0, i - 1));
                    cache.put(mark, value);
                }
                return value;
            }
        }
    }

    static class Marks {
        int head;
        int tail;

        public Marks(int head, int tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Marks marks = (Marks) o;

            if (head != marks.head) return false;
            return tail == marks.tail;

        }

        @Override
        public int hashCode() {
            int result = head;
            result = 31 * result + tail;
            return result;
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1});
//        System.out.println(numArray.sumRange(0, 0));
//        System.out.println(numArray.sumRange(0, 1));
//        System.out.println(numArray.sumRange(1, 1));
    }
}
