package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        if (a.length() > b.length()) {
            return addBinary2(a, b);
        } else {
            return addBinary2(b, a);
        }

    }

    private String addBinary2(String a, String b) {
        int shorterLength = b.length();
        int offset = a.length() - shorterLength;
        StringBuilder result = new StringBuilder();
        boolean higher = false;
        for (int i = shorterLength - 1; i >= 0; i--) {
            char charA = a.charAt(i + offset);
            char charB = b.charAt(i);

            CharResultAndHigher charResultAndHigher = process(charA, charB, higher);
            result.append(charResultAndHigher.charResult);
            higher = charResultAndHigher.higher;
        }

        if (higher) {
            for (int i = offset - 1; i >= 0; i--) {
                CharResultAndHigher charResultAndHigher = process(a.charAt(i), '0', higher);
                result.append(charResultAndHigher.charResult);
                higher = charResultAndHigher.higher;
            }

            if (higher) {
                result.append('1');
            }
        } else {
            return a.substring(0, offset) + result.reverse().toString();
        }

        return result.reverse().toString();
    }

    private CharResultAndHigher process(char charA, char charB, boolean higher) {
        char charResult;

        if (charA == '1') {
            if (charB == '1') {
                if (higher) {
                    charResult = '1';
                    higher = true;
                } else {
                    charResult = '0';
                    higher = true;
                }

            } else {
                if (higher) {
                    charResult = '0';
                    higher = true;
                } else {
                    charResult = '1';
                    higher = false;
                }
            }
        } else {
            if (charB == '1') {
                if (higher) {
                    charResult = '0';
                    higher = true;
                } else {
                    charResult = '1';
                    higher = false;
                }
            } else {
                if (higher) {
                    charResult = '1';
                    higher = false;
                } else {
                    charResult = '0';
                    higher = false;
                }
            }
        }
        return new CharResultAndHigher(charResult, higher);
    }

    static class CharResultAndHigher {
        char charResult;
        boolean higher;

        CharResultAndHigher(char charResult, boolean higher) {
            this.charResult = charResult;
            this.higher = higher;
        }
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "101010100";

        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));
    }
}
