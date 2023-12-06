package before.programmers.level2;

public class SearchLargestSquare {

    public static class Solution {
        public static int solution(int[][] board) {
            int[][] map = new int[board.length + 1][board[0].length + 1];

            int maxLen = 0;
            for (int i = 1; i <= board.length; i++) {
                for (int j = 1; j <= board[0].length; j++) {
                    if(board[i-1][j-1] != 0) {
                        int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                        map[i][j] = min + 1;
                        maxLen = Math.max(maxLen, min + 1);
                    }
                }
            }

            return maxLen * maxLen;
        }
    }
    
    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, 
                         {1, 1, 1, 1}, 
                         {1, 1, 1, 1}, 
                         {0, 0, 1, 0}};
        System.out.println(Solution.solution(board));
    }
}
