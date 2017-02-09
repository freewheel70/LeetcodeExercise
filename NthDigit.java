package leetcode;

/**
 * Created by freewheel on 2017/2/8.
 */
public class NthDigit {
    public static void main(String[] args) {
//        System.out.println("8 " + new NthDigit().findNthDigit(8));
        System.out.println("11 " + new NthDigit().findNthDigit(11));
        System.out.println("20 " + new NthDigit().findNthDigit(20));
        System.out.println("200 " + new NthDigit().findNthDigit(200));
    }

    // 9 one-digit         9  9*1        0    10^0
    // 90 two-dight      180  9*10*2     10   10^1
    // 900 three-digit  2700  9*100*3
    // 9000 four-digit 36000  9*1000*4
    public int findNthDigit(int n) {
        int sum = 9;
        int counter = 1;//num of bit
        int lastsum = 0;
        while (n > sum) {
            counter++;
            lastsum = sum;
            sum += (9 * Math.pow(10, counter - 1) * counter);
        }

        int rest = n - lastsum; // 8 - 0 = 8
        int nextCount = rest / counter; // 8 / 1 = 8
        int tail = rest % counter;//  8 % 1 = 0

        int result;
        int targetNumber = (int) Math.pow(10, counter - 1) + nextCount - 1;
        if (tail == 0) {
            result = targetNumber % 10;
        } else {
            targetNumber++;
            result = (int) (targetNumber / Math.pow(10, counter - tail));
            result = result % 10;

        }

        return result;
    }
}
