package leetcode.Others;

/**
 * Created by Administrator on 2016/7/8.
 */
public class AddBinary {
//    public String addBinary(String a, String b) {
//
//        if (a.length() > b.length()) {
//            return addBinary2(a, b);
//        } else {
//            return addBinary2(b, a);
//        }
//
//    }
//
//    private String addBinary2(String a, String b) {
//        int shorterLength = b.length();
//        int offset = a.length() - shorterLength;
//        StringBuilder result = new StringBuilder();
//        boolean higher = false;
//        for (int i = shorterLength - 1; i >= 0; i--) {
//            char charA = a.charAt(i + offset);
//            char charB = b.charAt(i);
//
//            CharResultAndHigher charResultAndHigher = process(charA, charB, higher);
//            result.append(charResultAndHigher.charResult);
//            higher = charResultAndHigher.higher;
//        }
//
//        if (higher) {
//            for (int i = offset - 1; i >= 0; i--) {
//                CharResultAndHigher charResultAndHigher = process(a.charAt(i), '0', higher);
//                result.append(charResultAndHigher.charResult);
//                higher = charResultAndHigher.higher;
//            }
//
//            if (higher) {
//                result.append('1');
//            }
//        } else {
//            return a.substring(0, offset) + result.reverse().toString();
//        }
//
//        return result.reverse().toString();
//    }
//
//    private CharResultAndHigher process(char charA, char charB, boolean higher) {
//        char charResult;
//
//        if (charA == '1') {
//            if (charB == '1') {
//                if (higher) {
//                    charResult = '1';
//                    higher = true;
//                } else {
//                    charResult = '0';
//                    higher = true;
//                }
//
//            } else {
//                if (higher) {
//                    charResult = '0';
//                    higher = true;
//                } else {
//                    charResult = '1';
//                    higher = false;
//                }
//            }
//        } else {
//            if (charB == '1') {
//                if (higher) {
//                    charResult = '0';
//                    higher = true;
//                } else {
//                    charResult = '1';
//                    higher = false;
//                }
//            } else {
//                if (higher) {
//                    charResult = '1';
//                    higher = false;
//                } else {
//                    charResult = '0';
//                    higher = false;
//                }
//            }
//        }
//        return new CharResultAndHigher(charResult, higher);
//    }
//
//    static class CharResultAndHigher {
//        char charResult;
//        boolean higher;
//
//        CharResultAndHigher(char charResult, boolean higher) {
//            this.charResult = charResult;
//            this.higher = higher;
//        }
//    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary3(a, b));
    }


    // 2017/2/15
    private String addBinary3(String a, String b) {
        int smallLen = Math.min(a.length(), b.length());
        boolean lastCarry = false;
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (index < smallLen) {
            char c1 = a.charAt(a.length() - 1 - index);
            char c2 = b.charAt(b.length() - 1 - index);
            char result = addChar(c1, c2, lastCarry);
            lastCarry = hasCarry;
            builder.append(result);
            index++;
        }

        if (a.length() > smallLen) {
            index = smallLen;
            while (index < a.length()) {
                char c1 = a.charAt(a.length() - 1 - index);
                char result = addChar(c1, '0', lastCarry);
                lastCarry = hasCarry;
                builder.append(result);
                index++;
            }
        }

        if (b.length() > smallLen) {
            index = smallLen;
            while (index < b.length()) {
                char c1 = b.charAt(b.length() - 1 - index);
                char result = addChar(c1, '0', lastCarry);
                lastCarry = hasCarry;
                builder.append(result);
                index++;
            }
        }

        if (lastCarry) {
            builder.append('1');
        }

        return builder.reverse().toString();
    }

    boolean hasCarry = false;

    private char addChar(char c1, char c2, boolean lastCarry) {
        if (c1 == '1' && c2 == '1') {
            hasCarry = true;
            return lastCarry ? '1' : '0';
        } else {
            if (c1 == '0' && c2 == '0') {
                hasCarry = false;
                return lastCarry ? '1' : '0';
            } else {
                if (lastCarry) {
                    hasCarry = true;
                    return '0';
                } else {
                    hasCarry = false;
                    return '1';
                }
            }
        }

    }

}
