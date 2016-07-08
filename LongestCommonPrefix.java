package leetcode;

/**
 * Created by Administrator on 2016/7/8.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = find(commonPrefix, strs[i]);
            if (commonPrefix.isEmpty()) {
                return "";
            }
        }

        return commonPrefix;
    }

    private String find(String str1, String str2) {
        if (str2.startsWith(str1)) {
            return str1;
        }

        int length1 = str1.length();
        int length2 = str2.length();
        int min = length1 < length2 ? length1 : length2;
        int commonIndex = -1;
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                commonIndex = i;
            } else {
                break;
            }
        }
        if (commonIndex == -1) {
            return "";
        }
        return str1.substring(0, commonIndex + 1);
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(new String[]{"c", "c"}));

    }

}
