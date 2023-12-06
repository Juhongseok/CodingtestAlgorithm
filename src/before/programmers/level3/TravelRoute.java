package before.programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TravelRoute {
    static class Solution {
        private static Queue<String> queue = new PriorityQueue<>();
        private static boolean[] visited;

        public static String[] solution(String[][] tickets) {
            visited = new boolean[tickets.length];
            dfs("ICN", "ICN", tickets, 0);
            return queue.peek().split(" ");
        }
        private static void dfs(String start, String route, String[][] tickets, int count) {
            if (count == tickets.length) {
                queue.add(route);
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (start.equals(tickets[i][0]) && !visited[i]) {
                    visited[i] = true;
                    dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(Solution.solution(tickets1)));
    }
}
