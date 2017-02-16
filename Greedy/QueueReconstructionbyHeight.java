package leetcode.Greedy;

import java.util.*;

/**
 * Created by freewheel on 2017/2/16.
 */
public class QueueReconstructionbyHeight {

    public static void main(String[] args) {
        int[][] people = {{8, 2}, {4, 1}, {0, 3}, {3, 2}, {8, 1}, {4, 0}, {7, 0}, {6, 2}, {8, 0}, {4, 7}};
        System.out.println(Arrays.deepToString(new QueueReconstructionbyHeight().reconstructQueue(people)));
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        //身高较高的在前面，同身高的，等待人数较少的在前面。
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        //数组被排序后
        //从头到尾，根据当前人的等待人数在新的列表中插入，由于后面插入的人比之前的矮，因此不会影响之前的人的等待人数
        int n = people.length;
        List<int[]> tmp = new LinkedList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][2];
        int i = 0;

        Iterator<int[]> iterator = tmp.iterator();
        while (iterator.hasNext()) {
            int[] k = iterator.next();
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }
//        for (int[] k : tmp) {
//            res[i][0] = k[0];
//            res[i++][1] = k[1];
//        }

        return res;
    }
}
