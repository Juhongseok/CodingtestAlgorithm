package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortest {
    static class Solution {
        public static int solution(int[][] maps) {
            int answer = 0;
            int[] moveX = {1, 0, -1, 0};
            int[] moveY = {0, -1, 0, 1};
            Node startNode = new Node(0, 0, 1);

            Queue<Node> queue = new LinkedList<>();
            queue.add(startNode);
            maps[0][0] = 0;

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.x == maps.length - 1 && current.y == maps[0].length - 1) {
                    return current.count;
                }
                for (int i = 0; i < 4; i++) {
                    int nextX = current.x + moveX[i];
                    int nextY = current.y + moveY[i];

                    try {
                        if (maps[nextX][nextY] == 1) {
                            queue.add(new Node(nextX, nextY, current.count + 1));
                            maps[nextX][nextY] = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }

            return -1;
        }
    }

    static class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(Solution.solution(maps));
    }
}
