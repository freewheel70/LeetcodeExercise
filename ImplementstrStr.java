package leetcode;

/**
 * Created by Administrator on 2016/7/9.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();

        if (needleLength == 0) {
            return 0;
        }

        int hayStackLength = haystack.length();
        if (hayStackLength == 0 || hayStackLength < needleLength) {
            return -1;
        } else if (hayStackLength == needleLength) {
            return haystack.equals(needle) ? 0 : -1;
        }


        for (int i = 0; i <= hayStackLength - needleLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean match = true;
                for (int j = needleLength - 1; j > 0; j--) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr impl = new ImplementstrStr();
        System.out.println(impl.strStr("hello", "lo"));
    }
}
