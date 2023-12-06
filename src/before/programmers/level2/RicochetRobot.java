package before.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot {
    static class Solution {
        public static int solution(String[] board) {
            String[][] boards = new String[board.length][board[0].length()];

            Point robot = null;
            Point goal = null;

            for (int i = 0; i < board.length; i++) {
                String[] line = board[i].split("");
                for (int j = 0; j < line.length; j++) {
                    boards[i][j] = line[j];
                    if (line[j].equals("R")) {
                        robot = new Point(i, j, 0);
                    }
                    if (line[j].equals("G")) {
                        goal = new Point(i, j, 0);
                    }
                }
            }

            return bfs(robot, goal, boards);
        }

        private static int[] moveX = {0, 1, 0, -1};
        private static int[] moveY = {1, 0, -1, 0};
        private static int bfs(Point robot, Point goal, String[][] boards) {
            Queue<Point> queue = new LinkedList<>();
            queue.add(robot);
            boolean[][] visited = new boolean[boards.length][boards[0].length];
            visited[robot.x][robot.y] = true;

            while (!queue.isEmpty()) {
                System.out.println(queue);
                Point current = queue.poll();

                if ((current.x == goal.x) && (current.y == goal.y)) {
                    return current.depth;
                }
                for (int i = 0; i < 4; i++) {
                    int nextX = current.x;
                    int nextY = current.y;
                    while (inRange(nextX, nextY, boards.length, boards[0].length) && !boards[nextX][nextY].equals("D")) {
                        nextX += moveX[i];
                        nextY += moveY[i];
                    }

                    nextX -= moveX[i];
                    nextY -= moveY[i];
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        Point e = new Point(nextX, nextY, current.depth + 1);
                        queue.add(e);
                    }
                }
            }
            return -1;
        }

        private static boolean inRange(int x, int y, int n, int m) {
            return x >= 0 && y >= 0 && x < n && y < m;
        }

        static class Point {
            int x;
            int y;
            int depth;

            public Point(int x, int y, int depth) {
                this.x = x;
                this.y = y;
                this.depth = depth;
            }

            @Override
            public String toString() {
                return "Point{" +
                        "x=" + x +
                        ", y=" + y +
                        ", depth=" + depth +
                        '}';
            }
        }
    }

    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(Solution.solution(board));
    }
}
