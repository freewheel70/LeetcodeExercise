package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/7/5.
 */
public class WordPattern {
    public boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        int wordLen = words.length;
        if (wordLen != pattern.length()) return false;

        @SuppressWarnings("unchecked")
        List<Integer>[] patternFlags = new ArrayList[26];
        for (int i = 0; i < wordLen; i++) {
            int index = charToInt(pattern.charAt(i));

            if (patternFlags[index] == null) {
                patternFlags[index] = new ArrayList<>();
            }
            patternFlags[index].add(i);
        }
        System.out.println(Arrays.toString(patternFlags));

        for (int i = 0; i < 26; i++) {
            List<Integer> positions = patternFlags[i];
            if (positions != null) {
                String theWord = words[positions.get(0)];
                for (int j = 0; j < wordLen; j++) {
                    if (positions.contains(j)) {
                        if (!theWord.equals(words[j])) {
                            return false;
                        }
                    } else {
                        if (theWord.equals(words[j])) {
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }

    private int charToInt(char c) {
        return c - 'a';
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int wordLen = words.length;
        if (wordLen != pattern.length()) return false;

        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < wordLen; i++) {
            List<Integer> list = map.get(words[i]);
            if (list == null) {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                map.put(words[i], positions);
            } else {
                list.add(i);
            }
        }

        Collection<List<Integer>> values = map.values();
        for (List<Integer> positions : values) {
            char theChar = pattern.charAt(positions.get(0));
            for (int i = 0; i < wordLen; i++) {
                if (positions.contains(i)) {
                    if (theChar != pattern.charAt(i)) {
                        return false;
                    }
                } else {
                    if (theChar == pattern.charAt(i)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        test("abba", "dog cat cat dog");
        test("abba", "dog cat cat fish");
        test("aaaa", "dog cat cat dog");
        test("abba", "dog dog dog dog");
    }

    private static void test(String pattern, String str) {
        System.out.println("pattern " + pattern);
        System.out.println("string " + str);
        System.out.println("result " + new WordPattern().wordPattern(pattern, str));
        System.out.println("--------------------");
    }
}
