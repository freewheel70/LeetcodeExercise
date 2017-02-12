package leetcode.Greedy;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/10.
 */
public class AssignCookies {
    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] children = {1, 2, 3};
        int[] cookies = {1, 1};
        System.out.println(assignCookies.findContentChildren(children, cookies));
    }

    //sort then traverse
    //with two pointers
    //Greedy match
    public int findContentChildren(int[] children, int[] cookies) {

        if (children.length == 0 || cookies.length == 0) return 0;

        Arrays.sort(children);
        Arrays.sort(cookies);

        int contentAmount = 0;

        int childPtr = 0;
        int cookiePtr = 0;

        while (cookiePtr < cookies.length && childPtr < children.length) {
            if (cookies[cookiePtr] >= children[childPtr]) {
                contentAmount++;
                cookiePtr++;
                childPtr++;
            } else {
                cookiePtr++;
            }
        }

        return contentAmount;
    }
}
