package leetcode.Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by freewheel on 2017/2/20.
 */
public class MaximumXORofTwoNumbersinanArray {

    //using trie data structure
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Init Trie.
        Trie root = new Trie();
        for (int num : nums) {
            Trie curNode = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }

                curNode = curNode.children[curBit];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie curNode = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }

    static class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }
    }



    //if A ^ B = C then A ^ C = B
    public int findMaximumXOR2(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(new MaximumXORofTwoNumbersinanArray().findMaximumXOR2(nums));
    }
}
