package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/13.
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        //case
        //null ""  abcab  abcdabe  abcabc

        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abacababacab"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcae"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabc"));
    }


    //check every substring in string
    public boolean repeatedSubstringPattern(String str) {
        if (str == null) return false;
        if (str.equals("")) return true;
        int len = str.length();
        if (len == 1) return false;


        List<Integer> possibleLen = new ArrayList<>();
        for (int i = len / 2; i > 1; i--) {
            if (len % i == 0) {
                possibleLen.add(i);
            }
        }

        int index = 1;
        int possibleIndex = 0;
        boolean valid = false;

        String subString = str.substring(0, 1);

        while (true) {
            for (int i = 0; i < subString.length(); i++) {

                if (str.charAt(index) == subString.charAt(i)) {
                    index++;
                    valid = true;
                } else {
                    if (possibleIndex > possibleLen.size() - 1) return false;
                    subString = str.substring(0, possibleLen.get(possibleIndex++));
                    index = subString.length();
                    valid = false;
                    break;
                }
            }
            if (valid && index == str.length()) return true;
        }

    }


    //construct possible substrings to its results and compare with the target one
    public boolean repeatedSubstringPattern2(String str) {
        int l = str.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(str)) return true;
            }
        }
        return false;
    }
}
