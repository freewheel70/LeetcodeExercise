package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/20.
 */
public class IsSubsequence {
    public boolean isSubsequence(String sub, String source) {
        int subIndex = 0;
        int sourceIndex = 0;
        int subLen = sub.length();
        int mainLen = source.length();

        if (subLen > mainLen) return false;

        //Access the array is much faster than using charAt method
        //because charAt always validate the index in the beginning
        char[] subArray = sub.toCharArray();
        char[] sourceArray = source.toCharArray();


        //original code is like  while (subIndex < subLen && sourceIndex < mainLen) {...}
        //which waste time to repeatedly access the subArray[subIndex]
        while (subIndex < subLen) {
            char targetChar = subArray[subIndex];

            if (sourceIndex >= mainLen) return false;

            while (sourceIndex < mainLen) {
                if (targetChar == sourceArray[sourceIndex]) {
                    subIndex++;
                    sourceIndex++;
                    break;
                }
                sourceIndex++;
            }
        }

        return (subIndex == subLen);
    }


    public boolean isSubsequence2(String s, String t) {
        if (t.length() < s.length()) return false;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar, prev);
            if (prev == -1) return false;
            prev++;
        }

        return true;
    }
}
