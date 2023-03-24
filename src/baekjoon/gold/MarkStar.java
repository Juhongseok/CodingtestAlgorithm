package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MarkStar {

    private static Character[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        map = new Character[n][n * 2 - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }
        mark(0, n - 1, n);
        StringBuilder sb = new StringBuilder();
        for (Character[] characters : map) {
            for (int j = 0; j < map[0].length; j++) {
                sb.append(characters[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void mark(int row, int col, int n) {
        if (n == 3) {
            map[row][col] = '*';
            map[row + 1][col + 1] = map[row + 1][col - 1] = '*';
            map[row + 2][col - 2] = map[row + 2][col - 1] = map[row + 2][col] = map[row + 2][col + 1] = map[row + 2][col + 2] = '*';
        } else {
            int next = n / 2;
            mark(row, col, next);
            mark(row + next, col + next, next);
            mark(row + next, col - next, next);
        }
    }
}
