package leetcode;

import java.util.LinkedList;


/**
 * Created by freewheel on 2017/2/9.
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext
 * dir
 * \tsubdir1
 * \tsubdir2
 * \t\tfile.ext
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        String path = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        new LengthLongestPath().lengthLongestPath(path);
    }


    //每个\n代表一个分层
    //\t数量越多，代表所在的层越深，root文件夹为0个，第一级文件夹为1个，以此类推

    public int lengthLongestPath(String input) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        String[] strings = input.split("\n");
        for (String s : strings) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size())
                stack.pop(); // find parent

            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"

            stack.push(len);
            // check if it is file
            if (s.contains("."))
                maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }
}
