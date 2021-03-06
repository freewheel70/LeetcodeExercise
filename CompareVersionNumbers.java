package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by Administrator on 2016/7/15.
 */
public class CompareVersionNumbers {
    public int compareVersion1(String version1, String version2) {
        String[] versionNums1 = version1.split("\\.");
        String[] versionNums2 = version2.split("\\.");
        int length1 = versionNums1.length;
        int length2 = versionNums2.length;
        if (length1 < length2) {
            for (int i = 0; i < length1; i++) {
                int temp1 = Integer.parseInt(versionNums1[i]);
                int temp2 = Integer.parseInt(versionNums2[i]);
                if (temp1 > temp2) {
                    return 1;
                } else if (temp1 < temp2) {
                    return -1;
                }
            }
            for (int i = length1; i < length2; i++) {
                int temp1 = 0;
                int temp2 = Integer.parseInt(versionNums2[i]);
                if (temp1 > temp2) {
                    return 1;
                } else if (temp1 < temp2) {
                    return -1;
                }
            }
        } else if (length1 > length2) {
            for (int i = 0; i < length2; i++) {
                int temp1 = Integer.parseInt(versionNums1[i]);
                int temp2 = Integer.parseInt(versionNums2[i]);
                if (temp1 > temp2) {
                    return 1;
                } else if (temp1 < temp2) {
                    return -1;
                }
            }
            for (int i = length2; i < length1; i++) {
                int temp1 = Integer.parseInt(versionNums1[i]);
                int temp2 = 0;
                if (temp1 > temp2) {
                    return 1;
                } else if (temp1 < temp2) {
                    return -1;
                }
            }

        } else {
            for (int i = 0; i < length1; i++) {
                int temp1 = Integer.parseInt(versionNums1[i]);
                int temp2 = Integer.parseInt(versionNums2[i]);
                if (temp1 > temp2) {
                    return 1;
                } else if (temp1 < temp2) {
                    return -1;
                }
            }

        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();
        int start1 = 0, start2 = 0;
        int currentVer1, currentVer2;
        int end1 = version1.indexOf('.');
        if (end1 == -1) {
            return compareShortVersion1(version1, version2);
        }
        int end2 = version2.indexOf('.');
        if (end2 == -1) {
            return -compareVersion(version2, version1);
        }

        while (!(start1 > end1 && start2 > end2)) {
            currentVer1 = (start1 > end1) ? 0 : Integer.parseInt(version1.substring(start1, end1));
            currentVer2 = (start2 > end2) ? 0 : Integer.parseInt(version2.substring(start2, end2));
            if (currentVer1 > currentVer2) {
                return 1;
            } else if (currentVer1 < currentVer2) {
                return -1;
            }

            start1 = end1 + 1;
            end1 = version1.indexOf('.', start1);
            if (end1 == -1) {
                end1 = length1;
            }

            start2 = end2 + 1;
            end2 = version2.indexOf('.', start2);
            if (end2 == -1) {
                end2 = length2;
            }
        }

        return 0;
    }

    private int compareShortVersion1(String version1, String version2) {
        int verNum1 = Integer.parseInt(version1);
        return compareShortVersion1(verNum1, version2);
    }

    private int compareShortVersion1(int verNum1, String version2) {
        int verNum2;
        int start2 = 0;
        int end2 = version2.indexOf('.');
        if (end2 == -1) {
            verNum2 = Integer.parseInt(version2);
            return verNum1 > verNum2 ? 1 : (verNum1 == verNum2 ? 0 : -1);
        } else {
            verNum2 = Integer.parseInt(version2.substring(start2, end2));
            if (verNum1 > verNum2) {
                return 1;
            } else if (verNum1 < verNum2) {
                return -1;
            } else {
                return compareShortVersion1(0, version2.substring(end2 + 1));
            }

        }
    }

    public static void main(String[] args) {
        test("1.2.3", "2.1");
        test("12.2.0", "12.2");
        test("1.2.3", "1.2.1.3");
        test("1.0.1", "1");
        test("1", "0");

//        System.out.println("1.0.1".substring(4, 5));
    }

    private static void test(String version1, String version2) {
        CompareVersionNumbers compare = new CompareVersionNumbers();
        System.out.println("version1 " + version1);
        System.out.println("version2 " + version2);
        System.out.println("result " + compare.compareVersion(version1, version2));
        System.out.println("---------------------------------");
    }

}
