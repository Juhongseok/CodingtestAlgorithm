package current.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class InterceptorSystem {

    static class Solution {
        public int solution(int[][] targets) {
            int answer = 1;
            Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

            int last = targets[0][1] - 1;
            for (int i = 1; i < targets.length; i++) {
                if (targets[i][0] <= last && last <= targets[i][1]) {
                    continue;
                }
                answer++;
                last = targets[i][1] - 1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        Solution solution = new Solution();
        System.out.println(solution.solution(targets));
    }

}
