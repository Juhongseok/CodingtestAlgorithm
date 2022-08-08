package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessReColor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rowCol = reader.readLine().split(" ");
        int row = Integer.parseInt(rowCol[0]);
        int col = Integer.parseInt(rowCol[1]);

        String[][] chess = new String[row][col];

        for (int i = 0; i < row; i++) {
            chess[i] = reader.readLine().split("");
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                answer = Math.min(answer, check(i, j, chess));
            }
        }

        System.out.println(answer);
    }

    private static int check(int row, int col, String[][] chess) {
        int change = 0;
        String before = "";
        for (int i = row; i < row+8; i++) {
            for (int j = col; j < col+8; j++) {
                String color = chess[i][j];

                if (before.equals(color)) {
                    change++;
                    color = color.equals("W") ? "B" : "W";
                }

                if (j == col + 7) {
                    before = color.equals("W") ? "B" : "W";
                } else {
                    before = color;
                }
            }
        }
        return Math.min(change, 64-change);
    }
}
