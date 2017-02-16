package leetcode.Others;

/**
 * Created by freewheel on 2017/2/16.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) return 0;

        int nextValidPoint = 0;
        int time = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] >= nextValidPoint) {
                time += duration;
            } else {
                time += timeSeries[i] - timeSeries[i - 1];
            }
            nextValidPoint = timeSeries[i] + duration;
        }

        return time;
    }
}
