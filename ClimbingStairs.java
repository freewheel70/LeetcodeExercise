package leetcode;

/**
 * Created by Administrator on 2016/6/22.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        /*
            1 = 1                                                                           1
            2=1+1 = 2                                                                       2
            3 = 1+2 = 1+1+1 = 2+1                                                           3
            4 = 1+1+1+1 = 1+ 2 +1 = 1+ 1+ 2 =  2+1+1 = 2+2                                  5
            5 = 1+1+1+1+1 = 1+1+1+2 = 1+1+2+1=1+2+1+1=2+1+1+1=  2+2+1 = 2+1+2 = 1+2+2       8
         */

        if (n == 1 || n == 2) return n;

        int num1 = 1;
        int num2 = 2;
        for (int i = 0; i < n - 2; i++) {
            int temp = num2;
            num2 = num1 + num2;
            num1 = temp;
        }

        return num2;
    }

    public static void main(String[] args){
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairs(4));
        System.out.println(climbingStairs.climbStairs(5));
    }
}
