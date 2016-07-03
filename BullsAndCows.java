package leetcode;


/**
 * Created by Administrator on 2016/7/3.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int length = secret.length();
        if (length != 0) {
            int[] secretFlags = new int[10];
            int[] guessFlags = new int[10];
            for (int i = 0; i < length; i++) {
                char secretChar = secret.charAt(i);
                char guessChar = guess.charAt(i);
                if (secretChar == guessChar) {
                    bull++;
                } else {
                    secretFlags[charToIndex(secretChar)]++;
                    guessFlags[charToIndex(guessChar)]++;
                }
            }

            for (int i = 0; i < 10; i++) {
                cow += lessOne(secretFlags[i], guessFlags[i]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bull);
        stringBuilder.append('A');
        stringBuilder.append(cow);
        stringBuilder.append('B');
        return stringBuilder.toString();
    }

    private int lessOne(int secretFlag, int guessFlag) {
        return (secretFlag < guessFlag) ? secretFlag : guessFlag;
    }

    private int charToIndex(char aChar) {
        return aChar - '0';
    }

    public static void main(String[] args) {
        test("1807", "7810");
        test("1123", "0111");
        test("1122", "2211");
    }

    private static void test(String secret, String guess) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        System.out.println("secret " + secret);
        System.out.println("guess " + guess);
        System.out.println("hint " + bullsAndCows.getHint(secret, guess));
        System.out.println("-------");
    }
}
