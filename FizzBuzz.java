package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/10.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(16));
    }

    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();

        int counterFor3 = 1;
        int counterFor5 = 1;
        for (int i = 1; i < n + 1; i++) {
            if (counterFor3 == 3) {
                if (counterFor5 == 5) {
                    results.add("FizzBuzz");
                    counterFor5 = 1;
                } else {
                    results.add("Fizz");
                    counterFor5++;
                }
                counterFor3 = 1;
            } else {
                if (counterFor5 == 5) {
                    results.add("Buzz");
                    counterFor5 = 1;
                } else {
                    results.add("" + i);
                    counterFor5++;
                }
                counterFor3++;
            }
        }

        return results;
    }
}
