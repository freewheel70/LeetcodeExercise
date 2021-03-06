package leetcode.Math;

/**
 * Created by freewheel on 2017/2/10.
 */
public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        int[] nums = {
                537, 410, 756, 667, 312, 62, 136, 229, 846, 902, 956, 752, 853, 999, 547, 245, 905,
                807, 594, 387, 91, 165, 492, 53, 268, 417, 202, 641, 709, 509, 423, 247,
                271, 180, 266, 936, 594, 754, 165, 440, 656, 473, 545, 510, 824, 92, 107,
                729, 251, 54, 468, 342, 219, 960, 395, 487, 729, 950, 128, 791, 811, 904, 390,
                435, 84, 656, 371, 678, 411, 888, 471, 419, 361, 16, 281, 185, 460, 389, 266,
                711, 443, 734, 53, 14, 46, 800, 501, 775, 750, 981, 918, 562, 885, 308, 349,
                969, 317, 720, 0, 728, 960, 471, 499, 321, 839, 781, 858, 299, 522, 124, 10, 317,
                858, 63, 331, 904, 863, 184, 31, 966, 165, 950, 880, 403, 258, 229, 724, 575, 949, 724, 655, 261,
                547, 507, 582, 386, 288, 792, 685, 162, 916, 695, 831, 126, 110, 514, 30, 974,
                698, 61, 292, 215, 11, 172, 618, 622, 401, 695, 549, 702, 419, 205, 963, 967,
                64, 897, 353, 704, 689, 391, 866, 605, 438, 49, 731, 549, 563, 113, 875, 613, 526, 167,
                828, 890, 339, 799, 512, 92, 846, 413, 794, 265, 970, 109, 584, 34, 6, 938, 738, 695, 681,
                956, 652, 119, 5, 735, 668, 568, 200, 895, 533, 726, 414, 714, 968, 753, 865, 480, 197, 711,


        };
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));

    }

    //把复杂的问题转换成简单的等价问题
    //increase n-1 elements  ==  decrease only one element
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
        }

        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
}
