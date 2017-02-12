package leetcode;

/**
 * Created by freewheel on 2017/2/12.
 */
public class Eggs {
    public static void main(String[] args) {

        for (int i = 0; i < 100000; i++) {
            if (isValid(i)) {
                System.out.println(i);
                break;
            }
        }

    }

    private static boolean isValid(int num) {

        return (num % 2 == 1) &&
                (num % 3 == 0) &&
                (num % 4 == 1) &&
                (num % 5 == 4) &&
                (num % 6 == 3) &&
                (num % 7 == 0) &&
                (num % 8 == 1) &&
                (num % 9 == 0);
    }
}
