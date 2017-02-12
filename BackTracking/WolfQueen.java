package leetcode.BackTracking;

/**
 * Created by freewheel on 2017/2/11.
 */
public class WolfQueen {
    /**
     * 一共有多少个皇后（此时设置为8皇后在8X8棋盘，可以修改此值来设置N皇后问题）
     */
    final int max = 8;
    /**
     * 该数组保存结果，第一个皇后摆在array[0]列，第二个摆在array[1]列
     * array 的 Index 代表 row
     * array 的 value 代表 column
     */
    int[] array = new int[max];

    public static void main(String[] args) {
        new WolfQueen().check(0);
    }

    /**
     * n代表当前是第几个皇后
     *
     * @param n 皇后n在array[n]列
     */
    private void check(int n) {
        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
        if (n == max) {
            print();
            return;
        }
        //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
        //这个逻辑代码中，有可能出现，递归到某一步发现无法通过isValid，因此“取消”了前面的所有步骤
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (isValid(n)) {
                check(n + 1);//递归
            }
        }
    }

    private boolean isValid(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + 1 + " ");
        }
        System.out.println();
    }
}
