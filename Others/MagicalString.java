package leetcode.Others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/17.
 */
public class MagicalString {
    //1 22 11 2 1 22 1 22 11 2 11 22 // driven by the second line
    //1 2  2  1 1  2 1 2  2  1  2  2 1 2 2 1 1 2 11 22

    public static void main(String[] args) {
        System.out.println(new MagicalString().magicalString2(6));
    }

    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int count = 3;
        int numOf1 = 1;
        int nextNum = 1;

        int countIndex = 2;

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);

        while (count <= n) {
            int nextAmount = numbers.get(countIndex);
            for (int i = 0; i < nextAmount; i++) {
                numbers.add(nextNum);
            }
            if (nextNum == 1) {
                numOf1 += nextAmount;
                nextNum = 2;
            } else {
                nextNum = 1;
            }
            count += nextAmount;
            countIndex++;
        }

        if (count > n) {
            int lastIndex = numbers.size() - 1;
            while (lastIndex >= n) {
                if (numbers.get(lastIndex) == 1) {
                    numOf1--;
                }
                lastIndex--;
            }
        }

        return numOf1;
    }

    //use array to improve efficiency
    public int magicalString2(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int count = 3;
        int numOf1 = 1;
        int nextNum = 1;

        int countIndex = 2;
        int valIndex = 3;

        int[] numbers = new int[n + 1];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 2;


        while (count < n) {
            int nextAmount = numbers[countIndex];
            for (int i = 0; i < nextAmount; i++) {
                numbers[valIndex+i] = nextNum;
            }
            valIndex += nextAmount;
            if (nextNum == 1) {
                numOf1 += nextAmount;
                nextNum = 2;
            } else {
                nextNum = 1;
            }
            count += nextAmount;
            countIndex++;
        }

        if (count > n) {
            if (numbers[n] == 1) numOf1--;
        }

        return numOf1;
    }
}
