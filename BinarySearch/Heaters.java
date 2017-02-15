package leetcode.BinarySearch;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/15.
 */
public class Heaters {

    public static void main(String[] args) {
        int[] houses = {1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999};
        int[] heaters = {499, 500, 501};
        System.out.println(new Heaters().findRadius(houses, heaters));
        Arrays.binarySearch(heaters, 1);
    }

    //using Java built-in Array binary search
    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }

    int distance = Integer.MIN_VALUE;

    public int findRadius(int[] houses, int[] heaters) {
        //
        Arrays.sort(heaters);

        for (int i = 0; i < houses.length; i++) {
            process(houses[i], heaters);
        }


        return distance;
    }

    private void process(int house, int[] heaters) {
        int start = 0;
        int end = heaters.length - 1;
        int mid;

        while (true) {
            mid = start + (end - start) / 2;
            if (house == heaters[mid]) {
                distance = Math.max(0,distance);
                break;
            } else if (house > heaters[mid]) {
                int dist = house - heaters[mid];
                if (mid + 1 < heaters.length) {
                    if (house <= heaters[mid + 1]) {
                        int dist2 = heaters[mid + 1] - house;
                        //choose the closer heat
                        distance = Math.max(distance, Math.min(dist, dist2));
                        break;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    distance = Math.max(dist,distance);
                    break;
                }
            } else {
                int dist = heaters[mid] - house;
                if (mid - 1 >= 0) {
                    if (house >= heaters[mid - 1]) {
                        int dist2 = house - heaters[mid - 1];
                        //choose the closer heat
                        distance = Math.max(distance, Math.min(dist, dist2));
                        break;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    distance = Math.max(dist,distance);
                    break;
                }
            }
        }
    }
}
