package before.programmers.level2;

import java.util.Arrays;

public class HanoiTower {
    static class Solution {
        private static int index = 0;
        public static int[][] solution(int n) {
            int[][] answer = new int[(int) (Math.pow(2,n)-1)][2];

            move(n, 1, 3, 2, answer);
            return answer;
        }

        public static void move(int n, int start, int end, int between, int[][] answer) {
            if (n == 1) {
                answer[index++] = new int[]{start, end};
                return;
            }
            move(n - 1, start, between, end, answer);
            answer[index++] = new int[]{start, end};
            move(n - 1, between, end, start, answer);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] solution = Solution.solution(n);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
