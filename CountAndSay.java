package leetcode;

/**
 * Created by Administrator on 2016/7/7.
 */
public class CountAndSay {
    //1, 11, 21, 1211, 111221, 312211,13112221,1113213211,31131211131221
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String last = "1";
        for (int i = 0; i < n - 1; i++) {
            last = say(last);
        }

        return last;
    }

    public String say(String str) {
        char flag = str.charAt(0);
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == flag) {
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(flag);
                flag = currentChar;
                count = 1;
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(flag);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.say("1211"));
        System.out.println(countAndSay.countAndSay(5));
    }

}
