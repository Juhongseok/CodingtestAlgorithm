package programmers.level3;

public class NExpression {
    static class Solution {

        private static int min = Integer.MAX_VALUE;

        public static int solution(int N, int number) {
            dfs(0, N, number, 0);
            if (min == Integer.MAX_VALUE) {
                return -1;
            }
            return min;
        }

        private static void dfs(int depth, int n, int number, int current) {
            if (depth == 8) {
                return;
            }
            if (number == current) {
                min = Math.min(depth, min);
                return;
            }
            int temp = 0;
            for (int i = 0; i < 8; i++) {
                if (depth + i < 8) {
                    temp = temp * 10 + n;
                    dfs(depth + i + 1, n, number, current + temp);
                    dfs(depth + i + 1, n, number, current - temp);
                    dfs(depth + i + 1, n, number, current * temp);
                    dfs(depth + i + 1, n, number, current / temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        System.out.println(Solution.solution(N, number));
    }
}
