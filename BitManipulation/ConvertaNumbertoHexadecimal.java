package leetcode.BitManipulation;

/**
 * Created by freewheel on 2017/2/11.
 */
public class ConvertaNumbertoHexadecimal {
    public static void main(String[] args) {
        System.out.println(new ConvertaNumbertoHexadecimal().toHex(26));
        System.out.println(new ConvertaNumbertoHexadecimal().toHex(-100000));
    }


    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    //because in common language, For negative integer, two’s complement method is used
    //so the method process negative and positive number should be the same
    //** operator >>> is shift number to right , and ALWAYS append 0 in the head
    //using simple array as map from number to hex
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result = result.insert(0, map[(num & 15)]);
            num = (num >>> 4);
        }
        return result.toString();
    }


    public String toHex2(int num) {
        if (num == 0) {
            return "0";
        } else {
            //26
            //11010
            //01111

            StringBuilder builder = new StringBuilder();

            int origin = num;

            while (origin != 0) {
                int temp = origin >> 4;
                temp = temp << 4;
                int lastFour = origin - temp;
                builder.insert(0, convertToHex(lastFour));
                origin = origin >>> 4;
            }

            return builder.toString();
        }
    }


    //method 1
    //process negative number and positive number in two ways
    public String toHex1(int num) {
        if (num < 0) {
            int diff = Math.abs(num + 1);
            //using ffffffff - diff

            StringBuilder result = new StringBuilder();//"ffffffff"
            int temp = diff;
            int counter = 0;

            while (counter < 8) {
                temp = diff & (15 << (counter * 4));
                temp = temp >> (counter * 4);
                int tempResult = 15 - temp;
                result.insert(0, convertToHex(tempResult));
                counter++;

            }

            return result.toString();

        } else if (num == 0) {
            return "0";
        } else {
            //26
            //11010
            //01111

            StringBuilder builder = new StringBuilder();

            int origin = num;

            while (origin != 0) {
                int temp = origin >> 4;
                temp = temp << 4;
                int lastFour = origin - temp;
                builder.insert(0, convertToHex(lastFour));
                origin = origin >> 4;
            }

            return builder.toString();
        }

    }

    private char convertToHex(int num) {
        if (num < 10) {
            return (char) (num + '0');
        } else {
            int diff = num - 10;
            return (char) (diff + 'a');
        }
    }

}
