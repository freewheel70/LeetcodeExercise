package leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by freewheel on 2017/2/14.
 */
public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsinaString().findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String mainStr, String subStr) {
        List<Integer> result = new ArrayList<>();

        int[] subMap = new int[26];
        for (int i = 0; i < subStr.length(); i++) {
            subMap[(subStr.charAt(i) - 'a')]++;
        }

        int lastIndex = 0;
        int currentIndex = 0;

        int counter = 0;

        while (currentIndex < mainStr.length()) {
            int mapPos = mainStr.charAt(currentIndex) - 'a';
            if (subMap[mapPos] == 0) {
                if (counter == 0) {
                    currentIndex++;
                    lastIndex = currentIndex;
                } else {
                    //fail , recover the subMap
                    subMap[mainStr.charAt(lastIndex) - 'a']++;
                    counter--;
                    lastIndex++;
                }
            } else {
                subMap[mapPos]--;
                counter++;

                if (counter == subStr.length()) {
                    result.add(lastIndex);
                    //recover the subMap first element
                    subMap[mainStr.charAt(lastIndex) - 'a']++;

                    counter--;
                    lastIndex++;
                    currentIndex++;
                } else {
                    currentIndex++;
                }
            }
        }

        return result;
    }

}
