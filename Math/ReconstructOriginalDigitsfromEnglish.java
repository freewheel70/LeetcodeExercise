package leetcode.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by freewheel on 2017/2/22.
 */
public class ReconstructOriginalDigitsfromEnglish {

    public static void main(String[] args) {
        System.out.println(new ReconstructOriginalDigitsfromEnglish().originalDigits("owoztneoer"));
    }

    boolean finish = false;

    //using backtracking but slow
    public String originalDigits(String s) {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<Integer> results = new ArrayList<>();
        boolean[] available = new boolean[s.length()];
        Arrays.fill(available, true);

        check(s.toCharArray(), available, results, digits);

        Collections.sort(results);
        StringBuilder builder = new StringBuilder();
        for (Integer result : results) {
            builder.append(result);
        }

        return builder.toString();
    }

    private void check(char[] target, boolean[] available, List<Integer> results, String[] digits) {
        if (findAll(available)) {
            finish = true;
            return;
        }

        for (String digit : digits) {

            int length = digit.length();

            //find a particular digit word
            boolean digitFound = true;
            for (int i = 0; i < length; i++) {
                char c = digit.charAt(i);

                boolean found = false;
                int targetLen = target.length;
                for (int j = 0; j < targetLen; j++) {
                    if (available[j] && target[j] == c) {
                        available[j] = false;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    //recover
                    for (int j = 0; j < i; j++) {
                        char recoverCh = digit.charAt(j);
                        for (int k = 0; k < targetLen; k++) {
                            if (!available[k] && target[k] == recoverCh) {
                                available[k] = true;
                                break;
                            }
                        }
                    }

                    digitFound = false;
                    break;//fail. Then find next digit
                }
            }

            if (digitFound) {
                int digitNum = getNum(digit, digits);
                results.add(digitNum);

                check(target, available, results, digits);

                if (finish) return;

                results.remove((Integer) digitNum);
                for (int i = 0; i < length; i++) {
                    char c = digit.charAt(i);

                    int targetLen = target.length;
                    for (int j = 0; j < targetLen; j++) {
                        if (!available[j] && target[j] == c) {
                            available[j] = true;
                            break;
                        }
                    }

                }
            }
        }

    }

    private int getNum(String digit, String[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i].equals(digit)) {
                return i;
            }
        }
        System.err.println("getNum Not found!");
        return 0;
    }

    private boolean findAll(boolean[] available) {
        boolean found = true;
        for (boolean avai : available) {
            if (avai) {
                found = false;
                break;
            }
        }
        return found;
    }

    //analyze the words and find the trick
    public String originalDigits1(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++){
            char c = chars[i];
            if (c == 'z') count[0]++;//only 0 zero has
            if (c == 'w') count[2]++;// two
            if (c == 'x') count[6]++;// six
            if (c == 's') count[7]++; //7-6 seven six
            if (c == 'g') count[8]++;//eight
            if (c == 'u') count[4]++;//four
            if (c == 'f') count[5]++; //5-4 // five four
            if (c == 'h') count[3]++; //3-8 // three eight
            if (c == 'i') count[9]++; //9-8-5-6 // nine eight five six
            if (c == 'o') count[1]++; //1-0-2-4 // one zero two four
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
