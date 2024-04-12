package current.programmers;

import java.util.Arrays;
import java.util.List;

public class MaxMinValue {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution("1 2 3 4");

        System.out.println("answer = " + answer);
    }

    static class Solution {
        public String solution(String s) {
            List<Integer> numbers = split(s);

            int max = numbers.get(0);
            int min = numbers.get(0);

            for (int number : numbers) {
                max = Math.max(number, max);
                min = Math.min(number, min);
            }

            return min + " " + max;
        }

        private List<Integer> split(String s) {
            return Arrays.stream(s.split(" "))
                    .map(Integer::parseInt)
                    .toList();
        }

    }

}
