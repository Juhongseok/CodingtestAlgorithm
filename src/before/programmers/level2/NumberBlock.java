package before.programmers.level2;

public class NumberBlock {

    static class Solution {
        public static int find(int num){
            if(num == 1)
                return 0;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0 && (num / i) <= 10_000_000) {
                    return num / i;
                }
            }
            return 1;
        }
        public static int[] solution(long begin, long end) {
            int start = (int) begin;
            int finish = (int) end;
            int[] answer = new int[finish - start + 1];

            for (int i = start; i <= finish; i++) {
                answer[(int) (i-begin)] = find(i);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;

        int[] result = Solution.solution(begin, end);

        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
