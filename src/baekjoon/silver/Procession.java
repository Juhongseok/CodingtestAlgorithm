package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Procession {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    change(a, i, j);
                    count++;
                }
            }
        }

        System.out.println(compare(a, b, count));
    }

    private static int compare(int[][] a, int[][] b, int count) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return -1;
                }
            }
        }
        return count;
    }

    private static void change(int[][] a, int row, int col) {
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                a[i][j] = a[i][j] ^ 1;
            }
        }
    }
}
