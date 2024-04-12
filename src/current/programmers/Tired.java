package current.programmers;

public class Tired {

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        Solution solution = new Solution();
        int answer = solution.solution(k, dungeons);

        System.out.println("answer = " + answer);
    }
    static class Solution {
        boolean check[];
        int answer = 0;

        public int solution(int k, int[][] dungeons) {
            check = new boolean[dungeons.length];
            clearDungeon(k, dungeons, 0);

            return answer;
        }

        private void clearDungeon(int k, int[][] dungeons, int count) {
            for (int i = 0; i < dungeons.length; i++) {
                if (!check[i] && dungeons[i][0] <= k) {
                    check[i] = true;
                    clearDungeon(k - dungeons[i][1], dungeons, count + 1);
                    check[i] = false;
                }
            }

            answer = Math.max(answer, count);
        }

    }

}
