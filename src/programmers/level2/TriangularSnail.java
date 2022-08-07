package programmers.level2;

public class TriangularSnail {
    static class Solution {
        public static int[] solution(int n) {
            int[] answer = new int[(n*(n+1))/2];
            int[][] temp = new int[n][n];

            int x = -1;
            int y = 0;
            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (i % 3 == 0) {
                        x++;
                    }
                    if (i % 3 == 1) {
                        y++;
                    }
                    if (i % 3 == 2) {
                        x--;
                        y--;
                    }
                    temp[x][y] = ++num;
                }
            }

            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][j] == 0) {
                        break;
                    }
                    answer[index++] = temp[i][j];
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] result = Solution.solution(n);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
