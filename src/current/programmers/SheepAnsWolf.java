package current.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SheepAnsWolf {

    static class Solution {
        int[] gInfo;
        int[][] gEdges;
        int maxSheepCnt = 0;

        public int solution(int[] info, int[][] edges) {
            gInfo = info;
            gEdges = edges;
            boolean[] initVisited = new boolean[info.length];
            dfs(0, initVisited, 0, 0);

            return maxSheepCnt;
        }

        public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
            visited[idx] = true;
            if (gInfo[idx] == 0) {
                maxSheepCnt = Math.max(maxSheepCnt, ++sheepCnt);
            } else {
                wolfCnt++;
            }

            if (sheepCnt <= wolfCnt) {
                return;
            }

            for (int[] edge : gEdges) {
                if (visited[edge[0]] && !visited[edge[1]]) {
                    boolean[] nextVisited = new boolean[visited.length];
                    for (int i = 0; i < visited.length; i++) {
                        nextVisited[i] = visited[i];
                    }
                    dfs(edge[1], nextVisited, sheepCnt, wolfCnt);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        Solution solution = new Solution();
        System.out.println(solution.solution(info, edges));
    }

}
