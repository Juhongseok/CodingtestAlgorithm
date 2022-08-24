package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SearchMaze {
    private static final int[] moveX = {0, 1, 0, -1};
    private static final int[] moveY = {1, 0, -1, 0};
    private static Point[][] mazes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        mazes = new Point[n][m];
        for (int i = 0; i < n; i++) {
            String[] maze = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                mazes[i][j] = new Point(i, j, Integer.parseInt(maze[j]));
            }
        }

        findRoute();
        System.out.println(mazes[n-1][m-1].count);
    }

    private static void findRoute() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(mazes[0][0].setPoint(0));
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                try {
                    Point next = current.getNext(i);
                    if (next.canGo()) {
                        queue.add(next.setPoint(current.count));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
    }

    static class Point{
        int x;
        int y;
        int root;
        int count;
        boolean isVisit;

        public Point(int x, int y, int root) {
            this.x = x;
            this.y = y;
            this.root = root;
            this.count = 1;
            this.isVisit = false;
        }

        public Point getNext(int index) {
            return mazes[this.x + moveX[index]][this.y + moveY[index]];
        }

        public boolean canGo(){
            return this.root == 1 && !this.isVisit;
        }

        public Point setPoint(int count) {
            this.count += count;
            this.isVisit = true;
            return this;
        }
    }
}
