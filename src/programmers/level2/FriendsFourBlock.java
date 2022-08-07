package programmers.level2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendsFourBlock {
    static class Solution {
        public static int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] map = new char[m][n];
            for (int i = 0; i < board.length; i++) {
                map[i] = board[i].toCharArray();
            }

            while (true) {
                int check = check(map);
                if (check == 0) {
                    break;
                }
                answer += check;
                dropBlock(map);
            }
            return answer;
        }

        private static int check(char[][] board) {
            int row = board.length;
            int col = board[0].length;

            int count = 0;
            boolean[][] deleteBlock = new boolean[row][col];
            for (int i = 0; i < row -1; i++) {
                for (int j = 0; j < col -1; j++) {
                    if (board[i][j] != '.') {
                        checkFour(board, i, j, deleteBlock);
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (deleteBlock[i][j]) {
                        count++;
                        board[i][j] = '.';
                    }
                }
            }
            return count;
        }

        private static void checkFour(char[][] board, int row, int col, boolean[][] deleteBlock) {
            char flag = board[row][col];

            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    if (board[i][j] != flag) {
                        return;
                    }
                }
            }

            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    deleteBlock[i][j] = true;
                }
            }
        }

        private static void dropBlock(char[][] board) {
            for (int i = 0; i < board[0].length; i++) {
                Queue<Character> queue = new LinkedList<>();
                for (int j = board.length - 1; j >= 0; j--) {
                    if (board[j][i] != '.') {
                        queue.add(board[j][i]);
                    }
                }

                int index = board.length - 1;
                while (!queue.isEmpty()) {
                    board[index--][i] = queue.poll();
                }

                for (int j = index; j >= 0; j--) {
                    board[j][i] = '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(Solution.solution(m, n, board));
    }
}
