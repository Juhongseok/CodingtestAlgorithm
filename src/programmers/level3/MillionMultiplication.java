package programmers.level3;

import java.util.*;

public class MillionMultiplication {
    static class Solution {
        public static int[] solution(int e, int[] starts) {
            int[] answer = new int[starts.length];

            int[][] store = new int[e+1][2];
            store[e][0] = primeCount(e);
            store[e][1] = e;
            for(int i=e-1; i>=1; i--){
                int cnt = primeCount(i);

                if(cnt >= store[i+1][0]){
                    store[i][0] = cnt;
                    store[i][1] = i;
                }else{
                    store[i] = store[i+1];
                }
            }

            for (int i = 0; i < starts.length; i++) {
                int star = starts[i];
                answer[i] = store[star][1];
            }

            return answer;
        }

        private static int primeCount(int number) {
            Map<Integer, Integer> primes = new HashMap<>();

            for (int i = 2; i <= Math.sqrt(number); i++) {
                while (number % i == 0) {
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                    number /= i;
                }
            }

            if (number != 1) {
                primes.put(number, primes.getOrDefault(number, 0) + 1);
            }

            int count = 1;
            for (int value : primes.values()) {
                count *= value + 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int e = 8;
        int[] starts = {1, 3, 7};

        int[] solution = Solution.solution(e, starts);
        System.out.println(Arrays.toString(solution));
    }
}
