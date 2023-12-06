package before.programmers.level2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mine {
    static class Solution {
        private static int min = Integer.MAX_VALUE;
        private static Map<String, List<Integer>> energy;

        public static int solution(int[] picks, String[] minerals) {
            energy = new HashMap<>();
            energy.put("diamond", List.of(1, 5, 25));
            energy.put("iron", List.of(1, 1, 5));
            energy.put("stone", List.of(1, 1, 1));
            bfs(0, minerals.length, 0, picks, minerals);
            return min;
        }

        private static void bfs(int depth, int N, int sum, int[] picks, String[] minerals) {
            if (depth == N || picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
                min = Math.min(min, sum);
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (picks[i] == 0) {
                    continue;
                }
                picks[i]--;
                int temp = 0;
                for (int j = depth; j < Math.min(depth + 5, N); j++) {
                    temp += energy.get(minerals[j]).get(i);
                }
                bfs(Math.min(depth + 5, N), N, sum + temp, new int[]{picks[0], picks[1], picks[2]}, minerals);
                picks[i]++;
            }
        }

    }

    public static void main(String[] args) {
//        int[] picks = {1, 3, 2};
        int[] picks = {0, 1, 1};
//        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        System.out.println(Solution.solution(picks, minerals));
    }
}
