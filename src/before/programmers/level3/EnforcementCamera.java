package before.programmers.level3;


import java.util.Arrays;

public class EnforcementCamera {
    static class Solution {
        public static int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
            System.out.println(Arrays.deepToString(routes));
            int cam = Integer.MIN_VALUE;
            for (int[] route : routes) {
                if (cam < route[0]) {
                    cam = route[1];
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(Solution.solution(routes));
    }
}
