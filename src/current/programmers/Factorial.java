package current.programmers;

import java.util.stream.IntStream;

public class Factorial {

    static class Solution {

        public int loop(int number) {
            return IntStream.rangeClosed(1, number).reduce(1, (a, b) -> a * b);
        }

        public int recrusion(int number) {
            return number == 1 ? 1 : number * recrusion(number - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.recrusion(5));
    }

}
