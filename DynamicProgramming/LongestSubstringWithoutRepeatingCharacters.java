package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/24.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        char[] chars = s.toCharArray();

        //dp[i] -> length of the substring with current char as end
        int[] dp = new int[len];
        int max = 1;
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            char currentChar = chars[i];
            int checkingUpperBound = i - 1;
            int checkingLowerBound = i - dp[i - 1];
            int counter = 1;
            boolean foundRepeat = false;
            for (int j = checkingUpperBound; j >= checkingLowerBound; j--) {
                if (currentChar == chars[j]) {
                    break;
                } else {
                    counter++;
                }
            }
            dp[i] = counter;
            if (counter > max) max = counter;
        }

        return max;
    }
}
