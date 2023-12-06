package before.programmers.level2;

import java.util.*;

public class UninhabitedIslandTravel {
    static class Solution {
        static char[][] map;
        static boolean[][] visited;
        public static int[] solution(String[] maps) {
            map = new char[maps.length][maps[0].length()];
            visited = new boolean[maps.length][maps[0].length()];

            for(int i=0; i<maps.length; i++) {
                map[i] = maps[i].toCharArray();
            }

            List<Integer> result = new ArrayList<>();
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map[i].length; j++){
                    if(map[i][j] != 'X' && !visited[i][j]) {
                        result.add(getSum(i, j));
                    }
                }
            }
            if (result.size() == 0) {
                return new int[]{-1};
            }
            int[] answer = result.stream().mapToInt(integer -> integer).toArray();
            Arrays.sort(answer);
            return answer;
        }

        static int[] moveX = {0,1,0,-1};
        static int[] moveY = {1,0,-1,0};
        private static int getSum(int x, int y) {
            int result = 0;
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(x, y));
            visited[x][y] = true;
            while (!queue.isEmpty()) {
                Point current = queue.poll();
                result += Integer.parseInt(String.valueOf(map[current.x][current.y]));

                for(int i=0; i<4; i++) {
                    int nextX = current.x + moveX[i];
                    int nextY = current.y + moveY[i];

                    if(check(nextX, nextY)) {
                        queue.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
            return result;
        }

        private static boolean check(int x, int y) {
            return (0<=x && x<map.length) && (0<=y && y<map[0].length) && (map[x][y] != 'X') &&
                    (!visited[x][y]);
        }

        static class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        System.out.println(Arrays.toString(Solution.solution(maps)));
    }
}
