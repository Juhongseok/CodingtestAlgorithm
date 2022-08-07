package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class LineWay {
    static class Solution {
        public static int[] solution(int n, long k) {
            int[] answer = new int[n];
            List<Integer> list = new ArrayList<>();

            long count = 1;
            for (int i = 1; i <= n; i++) {
                list.add(i);
                count *= i;
            }
            k--;
            int index = 0;
            while (n > 0) {
                count /= n--;
                answer[index++] = list.remove((int) (k / count));
                k %= count;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        long k = 7;

        int[] result = Solution.solution(n, k);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
