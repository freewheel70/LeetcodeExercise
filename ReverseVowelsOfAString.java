package leetcode;

/**
 * Created by Administrator on 2016/6/24.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {

        if (s == null || s.length() == 0) return s;

        char[] charArray = s.toCharArray();
        int index1 = 0;
        int index2 = charArray.length - 1;
        while (index1 <= index2) {
//            System.out.println("index1 " + index1 + "  ;index2 " + index2);
            char char1 = charArray[index1];
            if (isVowels(char1)) {
                while (index1 != index2 && !isVowels(charArray[index2])) {
                    index2--;
                }
                if (index1 > index2) {
                    break;
                } else {
                    charArray[index1] = charArray[index2];
                    charArray[index2] = char1;
                    index1++;
                    index2--;
                }
            } else {
                index1++;
            }
        }

        return new String(charArray);
    }

    private boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        test("hello");
        test("leetcode");
        test("ai");
        test("aie");
        test("aA");
    }

    private static void test(String str) {
        ReverseVowelsOfAString reverseVowels = new ReverseVowelsOfAString();
        String result = reverseVowels.reverseVowels(str);
        System.out.println("input: " + str + " ; output: " + result);
    }
}
