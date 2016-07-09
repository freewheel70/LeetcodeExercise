package leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/9.
 */
public class RangeSumQueryImmutable {
    static class NumArray {

        HashMap<Marks, Integer> cache = new HashMap<>();

        int[] nums = null;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int result = 0;
            if (i == j) {
                return nums[i];
            } else {
                Marks currentMark = new Marks(i, j);
                Integer value = cache.get(currentMark);
                if (value != null) {
                    return value;
                } else {
                    if (j - i > 10) {
                        for (int k = 0; k < j - i - 10; k++) {
                            result += nums[i + k];
                        }
                        result += sumRange(j - 10, j);
                    } else {
                        result = nums[i] + sumRange(i + 1, j);
                    }
                    cache.put(currentMark, result);
                }
            }

            return result;
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

    }
}
