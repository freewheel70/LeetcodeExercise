package leetcode;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by freewheel on 2017/2/25.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) return Collections.emptyList();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        });

        List<Interval> results = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval curInterval = intervals.get(i);
            if (curInterval.start <= end) {
                if (curInterval.end > end) {
                    end = curInterval.end;
                }
            } else {
                results.add(new Interval(start, end));
                start = curInterval.start;
                end = curInterval.end;
            }
        }

        results.add(new Interval(start, end));

        return results;
    }

    public int countIntervals(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) return 0;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        });


        int counter = 0;

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        Interval lastInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curInterval = intervals.get(i);
            if (curInterval.start <= end) {
                if (curInterval.end > end) {
                    end = curInterval.end;
                }
            } else {

                if (end == lastInterval.end) {
                    counter++;
                }

                start = curInterval.start;
                end = curInterval.end;
                lastInterval = curInterval;
            }
        }


        if (end == lastInterval.end) {
            counter++;
        }

        return counter;
    }

    static public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
