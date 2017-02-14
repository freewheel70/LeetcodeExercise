package leetcode;

/**
 * Created by freewheel on 2017/2/14.
 */
public class NumberofSegmentsinString {
    public static void main(String[] args) {
        System.out.println(new NumberofSegmentsinString().countSegments("     "));
    }


    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;

        int counter = 0;
        boolean wordStart = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (wordStart) {
                    counter++;
                    wordStart = false;
                }
            } else {
                if (!wordStart) {
                    wordStart = true;
                }
            }
        }

        if (s.charAt(s.length() - 1) != ' ' && wordStart) {
            counter++;
        }

        return counter;
    }
}
