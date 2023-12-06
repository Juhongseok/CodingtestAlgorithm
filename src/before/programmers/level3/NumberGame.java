package before.programmers.level3;

import java.util.Arrays;

public class NumberGame {
    static class Solution {
        public static int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);
            for (int i = A.length-1, j = B.length - 1; i >= 0; i--) {
                if (A[i] < B[j]) {
                    answer++;
                    j--;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};
        System.out.println(Solution.solution(a, b) == 3);
    }
}
