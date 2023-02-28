package programmers.level3;

import java.util.*;

public class FarthestNode {
    static class Solution {
        public static int solution(int n, int[][] edge) {
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] node : edge) {
                int start = node[0];
                int end = node[1];
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            return bfs(graph, n);
        }

        private static int bfs(List<List<Integer>> graph, int nodeCount) {
            boolean[] visited = new boolean[nodeCount + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;

            int size = 0;
            while (!queue.isEmpty()) {
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer current = queue.poll();
                    for (Integer linkedNode : graph.get(current)) {
                        if (!visited[linkedNode]) {
                            queue.add(linkedNode);
                            visited[linkedNode] = true;
                        }
                    }
                }
            }
            return size;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}, {4,5}};

        System.out.println(Solution.solution(n, edge));
    }
}
