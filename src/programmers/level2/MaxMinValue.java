package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxMinValue {
    static class Result{
        public static String solution(String s) {
            List<Integer> arr = Arrays.stream(s.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            arr.sort(Comparator.naturalOrder());

            return arr.get(0) + " " + arr.get(arr.size()-1);
        }
    }
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(Result.solution(s));
    }
}
