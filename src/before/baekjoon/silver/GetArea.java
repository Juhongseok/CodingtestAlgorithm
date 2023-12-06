package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GetArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol = reader.readLine().split(" ");

        int M = Integer.parseInt(rowCol[0]);
        int N = Integer.parseInt(rowCol[1]);
        int K = Integer.parseInt(rowCol[2]);


        Point[][] point = new Point[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                point[i][j] = new Point(i, j, true);
            }
        }

        for (int i = 0; i < K; i++) {
            String[] points = reader.readLine().split(" ");

            int x1 = Integer.parseInt(points[0]);
            int y1 = Integer.parseInt(points[1]);
            int x2 = Integer.parseInt(points[2]);
            int y2 = Integer.parseInt(points[3]);

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    point[k][j] = new Point(k,j,false);
                }
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (point[i][j].isArea) {
                    count++;
                    sb.append(check(point, i, j) + " ");
                }
            }
        }

        List<Integer> collect = Arrays.stream(sb.toString().split(" "))
                .map(s -> Integer.valueOf(s))
                .sorted()
                .collect(Collectors.toList());

        sb = new StringBuilder();
        for (Integer integer : collect) {
            sb.append(integer + " ");
        }

        System.out.println(count + "\n" + sb.delete(sb.length()-1, sb.length()));
    }

    private static int check(Point[][] point, int startRow, int startCol) {
        int size = 1;

        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};

        Stack<Point> stack = new Stack<>();
        stack.push(point[startRow][startCol]);
        point[startRow][startCol].isArea = false;
        while (!stack.isEmpty()) {
            Point current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + moveX[i];
                int nextY = current.y + moveY[i];

                try {
                    Point next = point[nextX][nextY];
                    if (next.isArea) {
                        stack.push(next);
                        next.isArea = false;
                        size++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }

        }
        return size;
    }

    private static class Point{
        int x;
        int y;
        boolean isArea;

        public Point(int x, int y, boolean isArea) {
            this.x = x;
            this.y = y;
            this.isArea = isArea;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", isArea=" + isArea +
                    '}';
        }
    }
}
