package leetcode;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/14.
 */
public class KMPMyTry {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KMPMyTry().buildMatchTable("abcdabeaabcd")));
        System.out.println(new KMPMyTry().containSubstring("baabcdabeaabcdc", "abcdabeaabcd"));

        System.out.println(new KMPMyTry().containSubstring("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }


    public int containSubstring(String source, String sub) {
        int[] matchTable = buildMatchTable(sub);

        return searchSubstring(source, sub, matchTable);
    }

    private int searchSubstring(String source, String sub, int[] matchTable) {

        int sourceIndex = 0;
        int subIndex = 0;

        while (sourceIndex < source.length()) {
            if (source.charAt(sourceIndex) == sub.charAt(subIndex)) {
                if (subIndex == sub.length() - 1) {
                    return sourceIndex - sub.length() + 1;
                } else {
                    sourceIndex++;
                    subIndex++;
                }
            } else {
                if (subIndex > 0) {
                    subIndex = matchTable[subIndex - 1];
                } else {
                    sourceIndex++;
                }
            }
        }

        return -1;
    }

    private int[] buildMatchTable(String sub) {
        int[] table = new int[sub.length()];

        table[0] = 0;
        int lastIndex = 0;
        int currentIndex = 1;
        int amount = 0;
        while (currentIndex < sub.length()) {
            if (sub.charAt(currentIndex) == sub.charAt(lastIndex)) {
                amount++;
                table[currentIndex] = amount;
                lastIndex++;
                currentIndex++;
            } else {
                if (lastIndex == 0) {
                    //comparing the head
                    table[currentIndex] = 0;
                    currentIndex++;
                } else {
                    amount = 0;
                    lastIndex = 0;
                }
            }
        }

        return table;
    }

}

