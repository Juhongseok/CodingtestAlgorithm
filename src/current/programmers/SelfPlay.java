package current.programmers;

import java.util.ArrayList;
import java.util.List;

public class SelfPlay {

    static class Solution {
        public int solution(int[] cards) {
            List<Integer> groups = new ArrayList<>();
            boolean[] visited = new boolean[cards.length];
            for (int i = 0; i < cards.length; i++) {
                int now = i;
                int count = 0;

                while (!visited[now]) {
                    count++;
                    visited[now] = true;
                    now = cards[now] - 1;
                }

                groups.add(count);
            }
            groups.sort((o1, o2) -> o2 - o1);

            return groups.size() == 1 ? 0 : groups.get(0) * groups.get(1);
        }

    }

    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(cards));
    }
}
