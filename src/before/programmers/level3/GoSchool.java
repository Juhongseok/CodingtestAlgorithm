package before.programmers.level3;

public class GoSchool {
    static class Solution {
        public static int solution(int m, int n, int[][] puddles) {
            int answer;
            int[][] map = new int[n][m];
            for (int[] puddle : puddles) {
                map[puddle[1]-1][puddle[0]-1] = -1;
            }
            map[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != -1) {
                        if (i >= 1 && map[i - 1][j] != -1) {
                            map[i][j] += map[i - 1][j];
                        }
                        if (j >= 1 && map[i][j - 1] != -1) {
                            map[i][j] += map[i][j - 1];
                        }
                        map[i][j] %= 1000000007;
                    }
                }
            }
            answer = map[n-1][m-1];
            return answer;
        }
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(Solution.solution(m, n, puddles));
    }
}
