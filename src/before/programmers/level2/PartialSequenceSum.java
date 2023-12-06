package before.programmers.level2;

import java.util.*;

public class PartialSequenceSum {
    static class Solution {
        public static int[] solution(int[] sequence, int k) {
            int left = 0;
            int right = 0;
            int n = sequence.length;
            int sum = 0;

            List<int[]> answers = new ArrayList<>();
            while (left <= right && right < n) {
                sum += sequence[right];
                if (sum >= k) {
                    while (sum > k) {
                        sum -= sequence[left++];
                    }
                    if (sum == k) {
                        answers.add(new int[]{left, right});
                    }
                }
                right++;
            }
            answers.sort(Comparator.comparingInt(o -> (o[1] - o[0])));
            return answers.get(0);
        }
    }

    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(Arrays.toString(Solution.solution(sequence, k)));
    }
}
