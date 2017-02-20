package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/18.
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(8));
    }

    //积最大的结果一定是由数个相同的值（还可能有一个不同的值）相乘得出的
    //从"相同值"为2开始尝试，逐渐增加,并记录最大值
    //当某一次的结果突然比之前记录的最大值来得小时结束循环（因为之后只会更小）
    //注意：当多个相同值加一个不同值的情况下，这个不同值既可能小于也可能大于该相同值，两种情况都需要计算，然后比较
    public int integerBreak(int n) {
        if (n < 3) return 1;

        int result = 1;

        int gap = 2;
        int tempN = n;
        int tempResult = 1;
        int count = 0;

        while (gap < n) {
            while (tempN >= gap) {
                tempN -= gap;
                tempResult *= gap;
                count++;
            }
            if (tempN != 0 && count > 1) {
                tempResult = Math.max(tempResult / gap * (tempN + gap), tempResult * tempN);
            }

            if (tempResult > result) {
                result = tempResult;
            } else if (tempResult < result) {
                break;
            }

            gap++;
            tempN = n;
            tempResult = 1;
            count = 0;
        }

        return result;
    }
}
