package current.programmers;

public class DiviseNumberCard {

    public static void main(String[] args) {
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};

        Solution solution = new Solution();
        int answer = solution.solution(arrayA, arrayB);

        System.out.println("answer = " + answer);
    }

    static class Solution {

        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;

            int gcdA = arrayA[0];
            int gcdB = arrayB[0];

            for (int i = 1; i < arrayA.length; i++) {
                gcdA = getGCD(gcdA, arrayA[i]);
                gcdB = getGCD(gcdB, arrayB[i]);
            }

            if (notDisible(gcdA, arrayB)) {
                answer = Math.max(answer, gcdA);
            }

            if (notDisible(gcdB, arrayA)) {
                answer = Math.max(answer, gcdB);
            }

            return answer;
        }

        public static int getGCD(int number1, int number2) {
            if (number1 % number2 == 0) {
                return number2;
            }

            return getGCD(number2, number1 % number2);
        }

        private boolean notDisible(int gcd, int[] arrayA) {
            for (int number : arrayA) {
                if (number % gcd == 0) {
                    return false;
                }
            }

            return true;
        }

    }

}
