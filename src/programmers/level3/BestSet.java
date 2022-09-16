package programmers.level3;

import java.util.Arrays;

public class BestSet {
    static class Solution {
        public static int[] solution(int n, int s) {
            int[] answer = new int[n];
            if (n > s) {
                return new int[]{-1};
            }

            int common = s / n;
            int div = s % n;
            for(int i = 0; i < n; i++){
                answer[i] = i >= n - div ? common + 1 : common;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] result = Solution.solution(2, 9);
        System.out.println(Arrays.toString(result));
    }
}
