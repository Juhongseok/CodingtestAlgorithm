package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Laboratory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] lab = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(makeWall(lab, 0));
    }

    private static int makeWall(int[][] lab, int wallCount) {
        int result = 0;
        if (wallCount == 3) {
            return check(spreadVirus(lab));
        }
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    result = Math.max(result, makeWall(lab, wallCount + 1));
                    lab[i][j] = 0;
                }
            }
        }
        return result;
    }

    private static int check(int[][] virusMap) {
        return Arrays.stream(virusMap)
                .mapToInt(row ->
                        (int) IntStream.range(0, virusMap[0].length)
                                .filter(j -> row[j] == 0)
                                .count())
                .sum();
    }

    private static int[][] spreadVirus(int[][] lab) {
        int[][] virusMap = Arrays.copyOf(lab, lab.length);

        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < virusMap.length; i++) {
            for (int j = 0; j < virusMap[0].length; j++) {
                if (virusMap[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                try {
                    int nextX = current.x + moveX[i];
                    int nextY = current.y + moveY[i];

                    if (virusMap[nextX][nextY] == 0) {
                        virusMap[nextX][nextY] = 2;
                        queue.add(new Point(nextX, nextY));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return virusMap;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
