package leetcode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by freewheel on 2017/2/22.
 */
public class MinimumNumberofArrowstoBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        int minArrowShots = new MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(points);
        System.out.println(minArrowShots);
    }


    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int len = points.length;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int counter = 0;

        int start = points[0][0];
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            int curStart = points[i][0];
            int curEnd = points[i][1];
            if (curStart > end) {
                counter++;
                start = curStart;
                end = curEnd;
            } else {
                if (curEnd < end) {
                    end = curEnd;
                }
            }
        }

        counter++;

        return counter;
    }
}
