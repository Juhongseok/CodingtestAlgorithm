package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    static class Solution {
        public static int solution(int cacheSize, String[] cities) {
            int answer = 5;

            Queue<String> queue = new LinkedList<>();
            queue.add(cities[0].toLowerCase());

            for (int i = 1; i < cities.length; i++) {
                String city = cities[i].toLowerCase();

                if (cacheSize == 0) {
                    answer += 5;
                    continue;
                }
                if (queue.contains(city)) {
                    queue.remove(city);
                    queue.add(city);
                    answer++;
                } else {
                    if (queue.size() == cacheSize) {
                        queue.poll();
                    }
                    queue.add(city);
                    answer += 5;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int cacheSize0 = 3;
        String[] cities0 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int cacheSize1 = 3;
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int cacheSize2 = 2;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int cacheSize3 = 5;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int cacheSize4 = 2;
        String[] cities4 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int cacheSize5 = 0;
        String[] cities5 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(Solution.solution(cacheSize0, cities0));
        System.out.println(Solution.solution(cacheSize1, cities1));
        System.out.println(Solution.solution(cacheSize2, cities2));
        System.out.println(Solution.solution(cacheSize3, cities3));
        System.out.println(Solution.solution(cacheSize4, cities4));
        System.out.println(Solution.solution(cacheSize5, cities5));
    }
}
