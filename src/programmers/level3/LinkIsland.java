package programmers.level3;

import java.util.*;

public class LinkIsland {
    static class Solution {
        static int[] parent;
        public static int solution(int n, int[][] costs) {
            Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            int total = 0;

            for (int[] cost : costs) {
                int fromParent = findParent(cost[0]);
                int toParent = findParent(cost[1]);

                if (fromParent != toParent) {
                    total += cost[2];
                    parent[toParent] = fromParent;
                }
            }
            return total;
        }

        private static int findParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(Solution.solution(n, costs));
    }
}
