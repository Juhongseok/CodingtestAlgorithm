package programmers.level2;

import java.util.PriorityQueue;

public class DefenseGame {
    static class Solution {
        public static int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int round = 0; round < enemy.length; round++) {
                queue.add(enemy[round]);
                if (queue.size() > k) {
                    n -= queue.poll();
                }
                if (n < 0) {
                    return round;
                }
            }
            return enemy.length;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        System.out.println(Solution.solution(n, k, enemy));
    }
}
