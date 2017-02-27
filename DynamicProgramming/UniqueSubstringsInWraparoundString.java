package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/24.
 */
public class UniqueSubstringsInWraparoundString {

    //I don't think the method is DP, but it works greatly
    //The key point is :
    //The max number of unique substring ends with a letter equals to the length of max contiguous
    // substring ends with that letter. Example "abcd",the max number of unique substring ends with 'd'
    // is 4, apparently they are "abcd", "bcd", "cd" and "d".
    public int findSubstringInWraproundString(String p) {
        int[] records = new int[26];

        char[] chars = p.toCharArray();
        int length = p.length();

        int counter = 0;
        for (int i = 0; i < length; i++) {
            char currentChar = chars[i];
            if (i == 0 || currentChar - chars[i - 1] == 1 || currentChar - chars[i - 1] == -25) {
                counter++;
            } else {
                counter = 1;
            }

            int index = currentChar - 'a';
            if (counter > records[index]) records[index] = counter;
        }

        int total = 0;
        for (int i = 0; i < 26; i++) {
            total+= records[i];
        }

        return total;
    }
}
