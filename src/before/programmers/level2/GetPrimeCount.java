package before.programmers.level2;

import java.util.Arrays;

public class GetPrimeCount {
    static class Solution {
        public static int solution(int n, int k) {
            return (int) Arrays.stream(Integer.toString(n, k).split("0+"))
                    .mapToLong(Long::parseLong)
                    .filter(Solution::isPrime)
                    .count();
        }

        private static boolean isPrime(long number) {
            if (number == 1) {
                return false;
            }

            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

//        int n = 110011;
//        int k = 10;
        System.out.println(Solution.solution(n, k));
    }
}
