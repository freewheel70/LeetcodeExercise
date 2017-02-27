package leetcode.Queue;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by freewheel on 2017/2/27.
 */
public class StrangeQueue {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        int[] nums = new int[groups];
        for (int i = 0; i < groups; i++) {
            int n = sc.nextInt();
            nums[i] = n;
        }

        for (int i = 0; i < groups; i++) {
            find(nums[i]);
            System.out.println();
        }
    }

    private static void find(int n) {

        int[] results = new int[n];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            queue.offer(-i);
        }

        int value = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            queue.offer(x);
            int index = queue.poll();
            results[-index] = value++;
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(results[i]);
            System.out.print(' ');
        }
        System.out.print(results[n - 1]);
        // 4 1 3 2 5
        // 3 2 5 4
        // 5 4 3
        // 4

    }
}
