package leetcode.BitManipulation;

/**
 * Created by freewheel on 2017/2/22.
 * https://leetcode.com/problems/maximum-product-of-word-lengths/?tab=Description
 *
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            char[] tempChars = tmp.toCharArray();
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tempChars[j] - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {

                //if their and result is zero , their contains no same characters!
                if ((value[i] & value[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    if (product > maxProduct) maxProduct = product;
                }

            }
        }
        return maxProduct;
    }
}
