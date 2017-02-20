package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by freewheel on 2017/2/20.
 * https://leetcode.com/problems/4sum-ii/?tab=Description
 */
public class FourSum2 {
    public static void main(String[] args) {

    }

    //try some ideas
    //sort arrays ?
    //select three numbers then find the fourth
    //hashmap save the values so that the count easy to get
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        Map<Integer, Integer> mapC = new HashMap<>();
        Map<Integer, Integer> mapD = new HashMap<>();

        for (int x : A) {
            mapA.put(x, mapA.getOrDefault(x, 0) + 1);
        }

        for (int x : B) {
            mapB.put(x, mapB.getOrDefault(x, 0) + 1);
        }

        for (int x : C) {
            mapC.put(x, mapC.getOrDefault(x, 0) + 1);
        }

        for (int x : D) {
            mapD.put(x, mapD.getOrDefault(x, 0) + 1);
        }

        Set<Integer> keysA = mapA.keySet();
        Set<Integer> keysB = mapB.keySet();
        Set<Integer> keysC = mapC.keySet();
        Set<Integer> keysD = mapD.keySet();

        int counter = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();

        for (Integer a : keysA) {
            for (Integer b : keysB) {
                int sum = a + b;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + (mapA.get(a) * mapB.get(b)));
            }
        }

        for (Integer c : keysC) {
            for (Integer d : keysD) {
                int sum = c + d;
                int existPairs = sumMap.getOrDefault(-sum, 0);
                if (existPairs != 0) {
                    counter += (mapC.get(c) * mapD.get(d) * existPairs);
                }
            }
        }

        //与其嵌套三个或者四个的for loop，不如拆分成两个for loop，会极大地降低时间复杂度

        return counter;
    }


    //although this method may compute some numbers duplicatedly
    //the method is easier and faster in general
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return res;
    }
}
