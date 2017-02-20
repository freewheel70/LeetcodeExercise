package leetcode.HashTable;

import java.util.*;

/**
 * Created by freewheel on 2017/2/17.
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Data> queue = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.amount - o1.amount;
            }
        });

        for (Character c : map.keySet()) {
            queue.offer(new Data(c, map.get(c)));
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            for (int i = 0; i < data.amount; i++) {
                builder.append(data.c);
            }
        }

        return builder.toString();
    }

    static class Data {
        char c;
        int amount;

        public Data(char c, int a) {
            this.c = c;
            this.amount = a;
        }
    }
}
