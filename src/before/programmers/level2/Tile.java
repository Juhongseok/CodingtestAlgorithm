package before.programmers.level2;

public class Tile {
    static class Solution {
        public static int solution(int n) {
            int[] result = new int[n];
            result[0] = 1;
            result[1] = 2;
            for (int i = 2; i < n; i++) {
                result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
            }
            return result[n-1];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Solution.solution(n));
    }
}
