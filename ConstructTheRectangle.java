package leetcode;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/10.
 * https://leetcode.com/problems/construct-the-rectangle/
 */
public class ConstructTheRectangle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConstructTheRectangle().constructRectangle(6)));
    }

    //考虑 sqrt 从double 截取到 int 的时候的精度损失
    public int[] constructRectangle(int area) {
        int[] ret = new int[2];
        int sqrt = (int) Math.sqrt(area);

        for (int i = sqrt; i > 0; i--) {
            if (area % i == 0) {
                ret[0] = area / i;
                ret[1] = i;
                break;
            }
        }


        return ret;
    }
}
