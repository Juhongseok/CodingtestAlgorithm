package baekjoon.silver;

import java.io.*;
import java.util.*;

public class EstateNumbering {
    static Estate[][] estates;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        estates = new Estate[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split("");
            for (int j = 0; j < N; j++) {
                estates[i][j] = new Estate(i, j, Integer.parseInt(s[j]));
            }
        }

        int sector = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (estates[i][j].canGo()) {
                    result.add(dfs(i, j) + 1);
                    sector++;
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        System.out.println(sector);
        result.forEach(System.out::println);
    }

    static int dfs(int x, int y) {
        int result = 0;
        Estate current = estates[x][y];
        current.visit = true;

        for (int i = 0; i < 4; i++) {
            try {
                Estate next = current.getNext(i);
                if (next.canGo()) {
                    result++;
                    result += dfs(next.x, next.y);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                doNoting();
            }
        }
        return result;
    }

    static class Estate{

        int x;
        int y;
        int house;
        boolean visit;
        public Estate(int x, int y, int house) {
            this.x = x;
            this.y = y;
            this.house = house;
            this.visit = false;
        }

        public boolean canGo() {
            return !visit && house == 1;
        }

        public Estate getNext(int i) {
            return estates[x + moveX[i]][y + moveY[i]];
        }

    }
    
    private static void doNoting() {
    }
}
