package leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by freewheel on 2017/2/27.
 * ref: https://github.com/checkcheckzz/coding-questions/blob/master/problem/String/Longest%20substring%20which%20appears%20more%20than%20once.cpp
 *
 */
public class LongestFrequentSubstring {

    public static void main(String[] args){
        System.out.println(new LongestFrequentSubstring().longestFrequentSubstring("abcdfscdfbc"));
    }

    //find Longest substring appears more than once
    public String longestFrequentSubstring(String s) {
        if (s == null) return null;
        int len = s.length();

        if (len <= 1) {
            return s;
        }

        List<String> records = new ArrayList<>();

        for (int i = 0; i < len - 1; i++) {
            records.add(s.substring(i, len));
        }

        Collections.sort(records);
        int maxLen = 0;
        String result = null;

        for (int i = 0; i < records.size() - 1; i++) {
            String s1 = records.get(i);
            String s2 = records.get(i + 1);
            int commonLen = 0;
            int index = 0;

            while (index < s1.length() && index < s2.length() && s1.charAt(index) == s2.charAt(index)) {
                commonLen++;
                index++;
            }

            if (commonLen > maxLen) {
                maxLen = commonLen;
                result = s1;
            }
        }

        return result == null ? null : result.substring(0, maxLen);
    }
}
