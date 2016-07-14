package leetcode;

/**
 * Created by Administrator on 2016/7/14.
 */
public class FirstBadVersion {

    int badIndex;

    public FirstBadVersion(int badIndex) {
        this.badIndex = badIndex;
    }

    public int firstBadVersion1(int n) {

        int head = 1;
        int tail = n;
        while (true) {
//            int examIndex = (head + tail) / 2; //overflow!
            int examIndex = head + ((tail - head) / 2);
            if (isBadVersion(examIndex)) {
                if (!isBadVersion(examIndex - 1)) {
                    return examIndex;
                } else {
                    tail = examIndex - 1;
                }
            } else {
                if (isBadVersion(examIndex + 1)) {
                    return examIndex + 1;
                } else {
                    head = examIndex + 1;
                }
            }
        }
    }

    public int firstBadVersion2(int n) {
        return find(1, n);
    }

    private int find(int head, int tail) {

//            int examIndex = (head + tail) / 2; //overflow!
        int examIndex = head + ((tail - head) / 2);
        if (isBadVersion(examIndex)) {
            if (!isBadVersion(examIndex - 1)) {
                return examIndex;
            } else {
                tail = examIndex - 1;
                return find(head, tail);
            }
        } else {
            if (isBadVersion(examIndex + 1)) {
                return examIndex + 1;
            } else {
                head = examIndex + 1;
                return find(head, tail);
            }
        }
    }

    //best one
    public int firstBadVersion(int n) {

        int head = 1;
        int tail = n;
        int examIndex = 1;
        while (true) {
//            int examIndex = (head + tail) / 2; //overflow!
            if (head == tail) return head;
            if (tail - head == 1) {
                if (!isBadVersion(head)) {
                    return tail;
                } else {
                    if (isBadVersion(tail)) {
                        return head;
                    }
                }
            } else {
                examIndex = head + ((tail - head) / 2);
            }
            if (isBadVersion(examIndex)) {
                tail = examIndex;
            } else {
                head = examIndex;
            }
        }
    }

    private boolean isBadVersion(int version) {
        return version >= badIndex;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion(2);
        System.out.println(firstBadVersion.firstBadVersion(2));
//        System.out.println(firstBadVersion.firstBadVersion(8));
//        System.out.println(firstBadVersion.firstBadVersion(13));
        //2126753390 versions
//        1702766719 is the first bad version.
    }
}
