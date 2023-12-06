package before.programmers.level2;

import java.util.Arrays;

public class NQueen {
    static class Solution {
        static int answer;
        public static int solution(int n) {
            answer = 0;
            return dfs(new int[n], 0);
        }

        private static int dfs(int[] map, int row) {
            System.out.println("map = " + Arrays.toString(map) + ", row = " + row);
            int sum = 0;
            if(row == map.length){
                return 1;
            }
            for (int col = 0; col < map.length; col++) {
                map[row] = col;
                if (check(map, row)) {
                    sum += dfs(map, row + 1);
                }
            }
            return sum;
        }

        private static boolean check(int[] map, int row) {
            for (int i = 0; i < row; i++) {
                if (map[i] == map[row] || Math.abs(i - row) == Math.abs(map[i] - map[row])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Solution.solution(n));
    }
}
