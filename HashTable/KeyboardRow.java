package leetcode.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by freewheel on 2017/2/9.
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(new KeyboardRow().findWords(words)));
    }

    public String[] findWords(String[] words) {
        List<HashSet<Character>> rows = new ArrayList<>();

        HashSet<Character> firstRow = new HashSet<>();
        firstRow.add('Q');
        firstRow.add('W');
        firstRow.add('E');
        firstRow.add('R');
        firstRow.add('T');
        firstRow.add('Y');
        firstRow.add('U');
        firstRow.add('I');
        firstRow.add('O');
        firstRow.add('P');

        rows.add(firstRow);

        HashSet<Character> secondRow = new HashSet<>();
        secondRow.add('A');
        secondRow.add('S');
        secondRow.add('D');
        secondRow.add('F');
        secondRow.add('G');
        secondRow.add('H');
        secondRow.add('J');
        secondRow.add('K');
        secondRow.add('L');

        rows.add(secondRow);

        HashSet<Character> thirdRow = new HashSet<>();
        thirdRow.add('Z');
        thirdRow.add('X');
        thirdRow.add('C');
        thirdRow.add('V');
        thirdRow.add('B');
        thirdRow.add('N');
        thirdRow.add('M');

        rows.add(thirdRow);

        List<String> validResult = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (isValid(words[i], rows)) {
                validResult.add(words[i]);
            }
        }

        String[] result = new String[validResult.size()];
        for (int i = 0; i < validResult.size(); i++) {
            result[i] = validResult.get(i);
        }

        return result;
    }

    private boolean isValid(String word, List<HashSet<Character>> rows) {
        word = word.toUpperCase();
        for (int i = 0; i < rows.size(); i++) {
            HashSet<Character> row = rows.get(i);
            if (row.contains(word.charAt(0))) {

                for (int j = 1; j < word.length(); j++) {
                    if (!row.contains(word.charAt(j))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
