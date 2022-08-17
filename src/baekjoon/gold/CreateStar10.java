package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class CreateStar10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[][] result = new String[n][n];

        createStar(0, 0, n, result, 0);
        StringBuilder sb = new StringBuilder();
        for (String[] strings : result) {
            for (String string : strings) {
                sb.append(string);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void createStar(int x, int y, int n, String[][] result, int count) {
        if (count == 5) {
            for (int i = x; i < x+n; i++) {
                for (int j = y; j < y+n; j++) {
                    result[i][j] = " ";
                }
            }
            return;
        }
        if (n == 1) {
            result[x][y] = "*";
            return;
        }

        int size = n / 3;
        int position = 0;
        for (int i = x; i < x+n; i+=size) {
            for (int j = y; j < y+n; j+=size) {
                position++;
                createStar(i, j, size, result, position);
            }
        }
    }
}
