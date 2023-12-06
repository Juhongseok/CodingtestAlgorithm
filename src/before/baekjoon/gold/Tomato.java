package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tomato {
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    private static Position[][] tomatoes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int size = n * m;

        tomatoes = new Position[m][n];
        Queue<Position> queue = new LinkedList<>();

        int none = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                tomatoes[i][j] = new Position(i, j, number);
                if (number == -1) {
                    none++;
                }else if (number == 1) {
                    queue.add(tomatoes[i][j]);
                }
            }
        }

        if (none + queue.size() == size) {
            System.out.println(0);
            return;
        }

        int lastDay = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                try {
                    Position next = current.getNext(i);
                    if (next.tomato == 0) {
                        queue.add(next.ripe(current.day));
                        lastDay = next.day;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    doNothing();
                }
            }
        }

        System.out.println(count + none == size ? lastDay : -1);
    }

    static class Position{
        int x;
        int y;
        int tomato;
        int day;

        public Position(int x, int y, int tomato) {
            this.x = x;
            this.y = y;
            this.tomato = tomato;
            this.day = 0;
        }

        public Position getNext(int i) {
            return tomatoes[x + moveX[i]][y + moveY[i]];
        }

        public Position ripe(int day){
            this.tomato = 1;
            this.day = day+1;
            return this;
        }
    }

    private static void doNothing() {
    }
}
