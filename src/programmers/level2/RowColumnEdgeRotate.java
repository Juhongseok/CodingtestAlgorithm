package programmers.level2;

public class RowColumnEdgeRotate {
    static class Solution {
        public static int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            int[][] array = new int[rows][columns];

            int index = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = index++;
                }
            }

            for (int j = 0; j < queries.length; j++) {
                int startX = queries[j][0] - 1;
                int startY = queries[j][1] - 1;
                int endX = queries[j][2] - 1;
                int endY = queries[j][3] - 1;

                int temp = array[startX][startY];
                int min = temp;
                for (int i = startX; i < endX; i++) {
                    array[i][startY] = array[i + 1][startY];
                    min = Math.min(min, array[i + 1][startY]);
                }

                for (int i = startY; i < endY; i++) {
                    array[endX][i] = array[endX][i + 1];
                    min = Math.min(min, array[endX][i + 1]);
                }

                for (int i = endX; i > startX; i--) {
                    array[i][endY] = array[i - 1][endY];
                    min = Math.min(min, array[i - 1][endY]);
                }

                for (int i = endY; i > startY; i--) {
                    array[startX][i] = array[startX][i - 1];
                    min = Math.min(min, array[startX][i - 1]);
                }

                array[startX][startY+1] = temp;
                answer[j] = min;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int row = 6;
        int column = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        int[] solution = Solution.solution(row, column, queries);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
