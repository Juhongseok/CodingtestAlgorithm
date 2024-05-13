package current.programmers;

public class CantorBit {

    static class Solution {

        public int solution(int n, long l, long r) {
            long answer = r - l + 1;

            for (long i = l - 1; i <= r - 1; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i / (int) Math.pow(5, j)) % 5 == 2) {
                        answer--;
                        break;
                    }
                }
            }

            return (int) answer;
        }

    }

    public static void main(String[] args) {
        int n = 2;
        long l = 4;
        long r = 17;

        Solution solution = new Solution();
        System.out.println(solution.solution(n, l, r));
    }

}
