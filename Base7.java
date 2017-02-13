package leetcode;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by freewheel on 2017/2/13.
 */
public class Base7 {
    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(0));
        System.out.println(new Base7().convertToBase7(49));
        System.out.println(new Base7().convertToBase7(13));
        System.out.println(new Base7().convertToBase7(5));
        System.out.println(new Base7().convertToBase7(-7));
    }


    public String convertToBase7(int num) {

        if (num == 0) return "0";
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }

        //consider positive number first
        //find the max bit
        int maxBit = 0;//100 49 maxBit=2 //101 50 maxBit = 3
        while (num >= Math.pow(7, maxBit)) {
            maxBit++;
        }

        int counter = maxBit - 1;
        StringBuilder ret = new StringBuilder();

        int temp = num;
        while (counter >= 0) {
            int pow7 = (int) Math.pow(7, counter);
            int bit = temp / pow7;
            ret.append(bit);
            temp = temp % pow7;
            counter--;
        }


        return ret.toString();
    }


    public String convertTo71(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.insert(0, Math.abs(num % 7));
            num = num / 7;
        }

        if (negative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }

    public String convertToBase72(int num) {
        return Integer.toString(num,7);
    }
}
