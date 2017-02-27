package leetcode;

import java.util.*;

/**
 * Created by freewheel on 2017/2/26.
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.println(new Permutation().permutation("abbc"));
    }

    public List<String> permutation(String s) {
        if (s == null) return Collections.emptyList();
        Set<String> results = new HashSet<>();
        int len = s.length();
        if (len <= 1) {
            results.add(s);
            return new ArrayList<>(results);
        } else {
            boolean[] masks = new boolean[len];
            Arrays.fill(masks, true);
            char[] current = new char[len];
            build(0, s, current, masks, results);
            List<String> raw = new ArrayList<>(results);
            Collections.sort(raw);
            return raw;
        }
    }

    private void build(int index, String s, char[] current, boolean[] masks, Set<String> results) {
        if (index == s.length()) {
            results.add(new String(current));
            return;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (masks[i]) {
                    current[index] = s.charAt(i);
                    masks[i] = false;
                    build(index + 1, s, current, masks, results);
                    masks[i] = true;

                }
            }
        }
    }
}
