package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderOperation {

    private static int[][] ladder;
    private static int width;
    private static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        width = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        ladder = new int[height + 1][width + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = 1;
            ladder[a][b + 1] = 2;
        }

        int i;
        for (i = 0; i <= 3; i++) {
            if (dfs(0, i)) {
                break;
            }
        }
        System.out.println(i <= 3 ? i : -1);
    }

    private static boolean dfs(int addCount, int indicator) {
        if (addCount == indicator) {
            return check();
        }

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j < width; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j + 1] = 2;

                    if (dfs(addCount + 1, indicator)) {
                        return true;
                    }

                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }
            }
        }
        return false;
    }

    private static boolean check() {
        for (int i = 1; i <= width; i++) {
            int x = i;
            int y = 1;

            while (y <= height) {
                if (ladder[y][x] == 1) {
                    x++;
                } else if (ladder[y][x] == 2){
                    x--;
                }
                y++;
            }

            if (x != i) return false;
        }

        return true;
    }
}
