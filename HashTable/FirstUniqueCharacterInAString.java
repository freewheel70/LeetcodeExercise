package leetcode.HashTable;

/**
 * Created by freewheel on 2017/2/10.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] records = new int[26];
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(records[s.charAt(i) - 'a']==1){
                return i;
            }
        }

        return -1;
    }
}
