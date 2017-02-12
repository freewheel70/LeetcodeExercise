package leetcode.HashTable;

/**
 * Created by freewheel on 2017/2/11.
 */
public class LongestPalindrome {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        int[] records = new int[52];
        int len = s.length();
        int num = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (index >= 0) {
                records[26 + index]++;
            } else {
                index = c - 'A';
                records[index]++;
            }
        }

        boolean oddExist = false;
        for (int i = 0; i < 52; i++) {
            if ((records[i] & 1) == 0) {//even
                num += records[i];
            } else {//odd
                oddExist = true;
                num += (records[i] - 1);
            }
        }
        if (oddExist)
            num += 1;

        return num;
    }
}
