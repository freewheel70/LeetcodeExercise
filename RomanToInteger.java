package leetcode;

/**
 * Created by Administrator on 2016/6/22.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int currentIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                result += 1000;
            } else if (i != s.length() - 1 && s.charAt(i + 1) == 'M') {
                result += 900;
                currentIndex = i + 2;
                break;
            } else {
                currentIndex = i;
                break;
            }
        }

        for (int i = currentIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                result += 500;
            } else if (i != s.length() - 1 && s.charAt(i + 1) == 'D') {
                result += 400;
                currentIndex = i + 2;
                break;
            } else {
                currentIndex = i;
                break;
            }
        }

        for (int i = currentIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'C') {
                result += 100;
            } else if (i != s.length() - 1 && s.charAt(i + 1) == 'C') {
                result += 90;
                currentIndex = i + 2;
                break;
            } else {
                currentIndex = i;
                break;
            }
        }

        for (int i = currentIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                result += 50;
            } else if (i != s.length() - 1 && s.charAt(i + 1) == 'L') {
                result += 40;
                currentIndex = i + 2;
                break;
            } else {
                currentIndex = i;
                break;
            }
        }

        for (int i = currentIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                result += 10;
            } else if (i != s.length() - 1 && s.charAt(i + 1) == 'X') {
                result += 9;
                currentIndex = i + 2;
                break;
            } else {
                currentIndex = i;
                break;
            }
        }

        for (int i = currentIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'V') {
                result += 5;
            } else if (i != s.length() - 1 && s.charAt(i + 1) == 'V') {
                result += 4;
                currentIndex = i + 2;
                break;
            } else {
                currentIndex = i;
                break;
            }
        }

        for (int i = currentIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result += 1;
            }
        }

        return result;
    }

    public static void main(String[] args){
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MDCCCLXXXVIII"));
    }
}
