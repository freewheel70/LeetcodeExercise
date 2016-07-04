package leetcode;

/**
 * Created by Administrator on 2016/7/4.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexM = 0, indexN = 0, mergedIndex = 0;
        int[] pureNums1 = new int[m];
        System.arraycopy(nums1, 0, pureNums1, 0, m);
        while (indexM < m && indexN < n) {
            if (pureNums1[indexM] < nums2[indexN]) {
                nums1[mergedIndex] = pureNums1[indexM];
                indexM++;
            } else {
                nums1[mergedIndex] = nums2[indexN];
                indexN++;
            }
            mergedIndex++;
        }
        while (indexM < m) {
            nums1[mergedIndex] = pureNums1[indexM];
            indexM++;
            mergedIndex++;
        }
        while (indexN < n) {
            nums1[mergedIndex] = nums2[indexN];
            indexN++;
            mergedIndex++;
        }
    }

}
