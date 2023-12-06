package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RedGreenColorWeakness {

    private static int[] moveX = {0, 1, 0, -1};
    private static int[] moveY = {1, 0, -1, 0};
    private static Point[][] picture;
    private static Point[][] picture1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        picture = new Point[n][n];
        picture1 = new Point[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                picture[i][j] = new Point(i, j, split[j]);
                picture1[i][j] = new Point(i, j, split[j].equals("G") ? "R" : split[j]);
            }
        }

        int normal = 0;
        int weak = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Point current = picture[i][j];
                if (!current.isVisit) {
                    Stack<Point> stack = new Stack<>();
                    stack.push(current);
                    current.isVisit = true;
                    check(stack, 0);

                    normal++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Point current = picture1[i][j];
                if (!current.isVisit) {
                    Stack<Point> stack = new Stack<>();
                    stack.push(current);
                    current.isVisit = true;
                    check(stack, 1);

                    weak++;
                }
            }
        }
        System.out.println(normal + " " + weak);
    }

    private static void check(Stack<Point> stack, int pictureNumber) {
        while (!stack.isEmpty()) {
            Point current = stack.pop();

            for (int i = 0; i < 4; i++) {
                try {
                    Point next = current.getNext(i, pictureNumber);

                    if (current.color.equals(next.color) && !next.isVisit) {
                        next.isVisit = true;
                        stack.push(next);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
            }
        }
    }

    static class Point{
        int x;
        int y;
        String color;
        boolean isVisit;

        public Point(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.isVisit = false;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", color='" + color + '\'' +
                    '}';
        }

        public Point getNext(int index, int pictureNumber) {
            return pictureNumber == 0 ? picture[x + moveX[index]][y + moveY[index]] : picture1[x + moveX[index]][y + moveY[index]];
        }
    }
}
