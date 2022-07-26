package programmers.level2;

public class ColoringBook {
    static class Solution {
        public static int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            int[] answer = new int[2];
            boolean[][] visited = new boolean[m][n];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] != 0 && !visited[i][j]) {
                        answer[0]++;
                        answer[1] = Math.max(answer[1], searchArea(i, j, picture, visited));
                    }
                }
            }
            return answer;
        }

        private static int searchArea(int i, int j, int[][] picture, boolean[][] visited) {
            int area = 1;
            visited[i][j] = true;

            int moveX[] = {-1, 0, 1, 0};
            int moveY[] = {0, -1, 0, 1};

            for (int k = 0; k < 4; k++) {
                try {
                    int nextX = i + moveX[k];
                    int nextY = j + moveY[k];
                    if (!visited[nextX][nextY] && picture[i][j] == picture[nextX][nextY]) {
                        area += searchArea(nextX, nextY, picture, visited);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
            return area;
        }
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] solution = Solution.solution(m, n, picture);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
